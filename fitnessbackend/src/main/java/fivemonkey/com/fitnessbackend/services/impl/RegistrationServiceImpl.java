package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.RegistrationDTO;
import fivemonkey.com.fitnessbackend.entities.Package;
import fivemonkey.com.fitnessbackend.entities.*;
import fivemonkey.com.fitnessbackend.repository.*;
import fivemonkey.com.fitnessbackend.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private PersonalTrainingRepository personalTrainingRepository;
    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private TraineeRepository traineeRepository;

    @Autowired
    private ServiceRepository servicesRepository;
    @Autowired
    private ModelMapperConfiguration<Registration, RegistrationDTO> modelMapper;

    @Override
    public boolean hasRegistration(String itemId, String userEmail) {
        return registrationRepository.findRegistrationByIdAndTrainee(getServices(itemId).getId(), userEmail) != null;
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
        String itemId = "";
        String itemName = "";
        String path = "";

        RegistrationDTO registrationDTO = modelMapper.map(registration, RegistrationDTO.class);
        Services service = registration.getServices();

        Clazz clazz = service.getClazz();
        if (clazz != null) {
            itemId = clazz.getId();
            itemName = clazz.getName();
            path = "/class/" + itemId;
        } else {
            Package packag3 = service.getAPackage();
            if (packag3 != null) {
                itemId = packag3.getId();
                itemName = packag3.getName();
            } else {
                PersonalTraining personalTraining = service.getPersonalTraining();
                itemId = personalTraining.getId();
                itemName = personalTraining.getName();
            }
        }

        registrationDTO.setItemId(itemId);
        registrationDTO.setItemName(itemName);
        registrationDTO.setPath(path);
        return registrationDTO;
    }

    private Registration makeRegistration(RegistrationDTO registrationDTO) {
        Registration registration = new Registration();
        return registration;
    }

    private Services getServices(String itemId) {
        Services services = null;
        Clazz clazz = classRepository.findById(itemId).orElse(null);
        if (clazz != null) {
            services = clazz.getServices();
        } else {
            Package packag3 = packageRepository.findById(itemId).orElse(null);
            if (packag3 != null) {
                services = packag3.getServices();
            } else {
                PersonalTraining personalTraining = personalTrainingRepository.findById(itemId).orElse(null);
                services = personalTraining.getServices();
            }
        }
        return services;
    }

    private Registration makeRegistration(User user, String itemId) {
        Registration registration = new Registration();
        registration.setTrainee(traineeRepository.getById(user.getEmail()));
        Services services = getServices(itemId);
        registration.setServices(services);
        registration.setDate(new Date());
        registration.setStartDate(getStartDateFromClass(services));
        return registration;
    }


    private Date getStartDateFromClass(Services services) {
        if(services.getClazz() == null){
            return null;
        }
        return services.getClazz().getSessions().isEmpty() ? null : services.getClazz().getSessions().get(0).getHappenedDate();
    }


    @Override
    public RegistrationDTO doRegistration(User user, String itemId) {
        return modelMapper.map(registrationRepository.save(makeRegistration(user, itemId)), RegistrationDTO.class);
    }
}
