package fivemonkey.com.fitnessbackend.service;
import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.RegistrationDTO;
import fivemonkey.com.fitnessbackend.entities.*;
import fivemonkey.com.fitnessbackend.repository.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import java.util.*;

@Service
public class RegistrationService {


    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private ClassRepository classRepository;

    @Autowired

    private TrainerRepository trainerRepository;
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private TraineeRepository traineeRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ModelMapperConfiguration<Registration, RegistrationDTO> modelMapper;

    
    public boolean hasRegistration(String serviceId, String userEmail) {
        return registrationRepository.findRegistrationByServicesAndTrainee(servicesRepository.getById(serviceId).getId(), userEmail) != null;
    }

    
    public boolean hasRegistrationPt(String trainerEmail, String userEmail) {
        return registrationRepository.findRegistrationByTrainerAndTrainee(trainerEmail, userEmail) != null;
    }

    
    public List<RegistrationDTO> getRegistrationsByUserEmail(String userEmail) {
        List<RegistrationDTO> registrations = new ArrayList<>();
        registrationRepository.getRegistrationByTrainee(userEmail).forEach(registration -> {
            registrations.add(makeRegistrationDTO(registration));
        });
        return registrations;
    }

    private RegistrationDTO makeRegistrationDTO(Registration registration) {
        RegistrationDTO registrationDTO = modelMapper.map(registration, RegistrationDTO.class);
        registrationDTO.setPath(registration.getClass() != null ? "/service/class/"+registrationDTO.getServicesId() : "");
        return registrationDTO;
    }

    private Registration makeRegistration(RegistrationDTO registrationDTO) {
        Registration registration = new Registration();
        return registration;
    }


    private Registration makeRegistration(User user, String serviceId) {
        Registration registration = new Registration();
        registration.setTrainee(traineeRepository.getById(user.getEmail()));
        Services services = servicesRepository.findById(serviceId).orElseGet(() -> classRepository.getClazzByServices(serviceId).getServices());
        registration.setServices(services);
        registration.setDate(new Date());
//        registration.setStartDate(services.getClazz()== null ? null : services.getClazz().getSessions().get(0).getHappenedDate());
        return registration;
    }

     
    public RegistrationDTO doRegistration(User user, String itemId) {
        return modelMapper.map(registrationRepository.save(makeRegistration(user, itemId)), RegistrationDTO.class);
    }


     
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

     
    public List<Registration> getAllRegistrationByAdmin() {
        return registrationRepository.getRegistrationByAdmin();
    }

     
    public Registration getRegistrationById(String id) {
        return registrationRepository.getById(id);
    }

     
    public void updateRegistration(Registration existingRegis) {
        registrationRepository.save(existingRegis);
    }

     
    public List<Registration> getRegistrationByManager(String studioId) {
        return registrationRepository.getRegistrationByManager(studioId);
    }


     
    public List<Registration> getRegistrationByAssistant(String email) {
        return registrationRepository.getRegistrationByAssistant(email);
    }

     
    public RegistrationDTO doRegistrationPt(String trainerEmail, User user, String serviceId) {
        return modelMapper.map(registrationRepository.save(addRegistration(trainerEmail, user, serviceId)), RegistrationDTO.class);
    }

     
    public boolean countRegistrationPT(String trainerEmail) {
        return registrationRepository.countRegistrationPT(trainerEmail) <= 3;
    }


    private Registration addRegistration(String trainerEmail, User user, String serviceId) {
        Registration registration = new Registration();
        registration.setTrainer(trainerRepository.getTrainerByEmail(trainerEmail));
        registration.setTrainee(traineeRepository.getById(user.getEmail()));
        Services services = servicesRepository.findById(serviceId).get();
        registration.setStartDate(services.getClazz() == null ? null : new Date());
        registration.setServices(services);
        registration.setDate(new Date());
        return registration;}

    public List<RegistrationDTO> getRegistrationByFilter(@Param("keyword") String keyword,
                                                         @Param("city") String city,
                                                         @Param("studio") String studio,
                                                         @Param("status") String registrationStatus,
                                                         int pageNumber) {
        int pageSize = 5;
        Session session = sessionFactory.openSession();
        String hql = "select r from Registration r where 1=1 ";
        if (keyword != null && !keyword.isEmpty()) {
            keyword = keyword.trim().replaceAll("\\s+", " ");
            hql += " and concat(r.services.name,r.services.price, r.services.serviceType) like '%" + keyword + "%' ";
        }
        if (city != null && !city.isEmpty()) {
            hql += "and r.services.city.id = '" + city +"' ";
        }
        if (studio != null && !studio.isEmpty()) {
            hql += " and r.services.studio.id = '" + studio +"' ";
        }
        if (registrationStatus != null && !registrationStatus.isEmpty()) {
            hql += "and r.status = '" + registrationStatus +"' ";
        }
        Query<Registration> query = session.createQuery(hql, Registration.class);
        query.setFirstResult(pageNumber * pageSize);
        query.setMaxResults(pageSize);
        return modelMapper.mapList(query.getResultList(), RegistrationDTO.class);
    }


    //Get total registration by filter
    public int  getTotalRegistrationByFilter(@Param("keyword") String keyword,
                                                         @Param("city") String city,
                                                         @Param("studio") String studio,
                                                         @Param("status") String registrationStatus
                                                ) {
        int pageSize = 5;
        Session session = sessionFactory.openSession();
        String hql = "select count(r.id) from Registration r where 1=1 ";
        if (keyword != null && !keyword.isEmpty()) {
            keyword = keyword.trim().replaceAll("\\s+", " ");
            hql += " and concat(r.services.name,r.services.price, r.services.serviceType) like '%" + keyword + "%' ";
        }
        if (city != null && !city.isEmpty()) {
            hql += "and r.services.city.id = '" + city +"'";
        }
        if (studio != null && !studio.isEmpty()) {
            hql += " and r.services.studio.name = '" + studio +"'";
        }
        if (registrationStatus != null && !registrationStatus.isEmpty()) {
            hql += "and r.status = '" + registrationStatus +"'";
        }
        Query queryCount = session.createQuery(hql);
        Long countResult = (Long) queryCount.uniqueResult();
        if ((int) (countResult % pageSize) != 0) {
            return (int) (countResult / pageSize) + 1;
        } else {
            return (int) (countResult / pageSize);
        }}
     
    public Registration getRegistrationByUser(String traineeEmail) {
        return registrationRepository.getRegistrationByUser(traineeEmail);
    }


    public List<RegistrationDTO> getListRegistrationByUser(String traineeEmail) {
        return modelMapper.mapList(registrationRepository.getListRegistrationByUser(traineeEmail), RegistrationDTO.class);
    }


}
