package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.RegistrationDTO;
import fivemonkey.com.fitnessbackend.entities.Registration;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.entities.Status;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.repository.ClassRepository;
import fivemonkey.com.fitnessbackend.repository.RegistrationRepository;
import fivemonkey.com.fitnessbackend.repository.ServicesRepository;
import fivemonkey.com.fitnessbackend.repository.TraineeRepository;
import fivemonkey.com.fitnessbackend.service.service.RegistrationService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {


    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private TraineeRepository traineeRepository;

    @Autowired
    private ServicesRepository servicesRepository;
    @Autowired
    private ModelMapperConfiguration<Registration, RegistrationDTO> modelMapper;

    @Override
    public boolean hasRegistration(String serviceId, String userEmail) {
        return registrationRepository.findRegistrationByServicesAndTrainee(servicesRepository.getById(serviceId).getId(), userEmail) != null;
    }

    @Override
    public boolean hasRegistrationPt(String trainerEmail, String userEmail) {
        return registrationRepository.findRegistrationByTrainerAndTrainee(trainerEmail,userEmail) != null;
    }

    @Override
    public List<RegistrationDTO> getRegistrationsByUserEmail(String userEmail) {
        List<RegistrationDTO> registrations = new ArrayList<>();
        registrationRepository.getRegistrationByTrainee(userEmail).forEach(registration -> {
            registrations.add(makeRegistrationDTO(registration));
        });
        return registrations;
    }

    private RegistrationDTO makeRegistrationDTO(Registration registration) {
        RegistrationDTO registrationDTO = modelMapper.map(registration, RegistrationDTO.class);
        registrationDTO.setPath(registration.getClass() != null ? "/class" : "");
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
        registration.setStartDate(services.getClazz().getSessions().isEmpty() ? null : services.getClazz().getSessions().get(0).getHappenedDate());
        return registration;
    }

    @Override
    public RegistrationDTO doRegistration(User user, String itemId) {
        return modelMapper.map(registrationRepository.save(makeRegistration(user, itemId)), RegistrationDTO.class);
    }

    @Override
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    @Override
    public List<Registration> getAllRegistrationByAdmin() {
        return registrationRepository.getRegistrationByAdmin();
    }

    @Override
    public Registration getRegistrationById(String id) {
        return registrationRepository.getById(id);
    }

    @Override
    public void updateRegistration(Registration existingRegis) {
        registrationRepository.save(existingRegis);
    }

    @Override
    public List<Registration> getRegistrationByManager(String studioId) {
        return registrationRepository.getRegistrationByManager(studioId);
    }


//    @Override
//    public List<Registration> getRegistrationByManager(String studioId) {
//        return registrationRepository.getRegistrationByManager(studioId);
//    }

    @Override
    public List<Registration> getRegistrationByAssistant(String email) {
        return registrationRepository.getRegistrationByAssistant(email);
    }

    @Override
    public List<RegistrationDTO> getRegistrationByFilter(@Param("keyword") String keyword,
                                                      @Param("city") String city,
                                                       @Param("studio") String studio,
                                                      @Param("status") String registrationStatus) {
        Session session = sessionFactory.openSession();
        String hql = "select r from Registration r where 1=1 ";
        if (keyword != null && !keyword.isEmpty()) {
            hql += " and concat(r.services.name,r.services.price, r.services.serviceType, r.date) like '%" + keyword + "%' ";
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

        Query<Registration> query = session.createQuery(hql, Registration.class);
        return modelMapper.mapList(query.getResultList(), RegistrationDTO.class);
    }


}
