package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.RegistrationDTO;
import fivemonkey.com.fitnessbackend.entities.*;
import fivemonkey.com.fitnessbackend.repository.*;
import fivemonkey.com.fitnessbackend.service.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.*;

@Service
public class RegistrationServiceImpl implements RegistrationService {


    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private TrainerRepository trainerRepository;
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

    @Override
    public boolean hasRegistration(String serviceId, String userEmail) {
        return registrationRepository.findRegistrationByServicesAndTrainee(servicesRepository.getById(serviceId).getId(), userEmail) != null;
    }

    @Override
    public boolean hasRegistrationPt(String trainerEmail, String userEmail) {
        return registrationRepository.findRegistrationByTrainerAndTrainee(trainerEmail, userEmail) != null;
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


    @Override
    public List<Registration> getRegistrationByAssistant(String email) {
        return registrationRepository.getRegistrationByAssistant(email);
    }

    @Override
    public RegistrationDTO doRegistrationPt(String trainerEmail, User user, String serviceId) {
        return modelMapper.map(registrationRepository.save(addRegistration(trainerEmail, user, serviceId)), RegistrationDTO.class);
    }

    @Override
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
        return registration;
    }


}
