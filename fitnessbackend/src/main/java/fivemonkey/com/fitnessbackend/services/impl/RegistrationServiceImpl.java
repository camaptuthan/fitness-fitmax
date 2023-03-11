package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.PackageDTO;
import fivemonkey.com.fitnessbackend.dto.PersonalTrainingDTO;
import fivemonkey.com.fitnessbackend.dto.RegistrationDTO;
import fivemonkey.com.fitnessbackend.entities.Registration;
import fivemonkey.com.fitnessbackend.repository.RegistrationRepository;
import fivemonkey.com.fitnessbackend.services.ClassService;
import fivemonkey.com.fitnessbackend.services.PackageService;
import fivemonkey.com.fitnessbackend.services.PersonalTrainingService;
import fivemonkey.com.fitnessbackend.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private ClassService classService;
    @Autowired
    private PersonalTrainingService personalTrainingService;
    @Autowired
    private PackageService packageService;

    @Autowired
    private ModelMapperConfiguration<Registration, RegistrationDTO> modelMapper;

    @Override
    public List<RegistrationDTO> getRegistrationByUserEmail(String userEmail) {
        List<RegistrationDTO> registrations = new ArrayList<>();

        registrationRepository.getRegistrationByTrainee(userEmail).forEach(registration -> {

            String itemId = "";
            String itemName = "";

            RegistrationDTO registrationDTO = modelMapper.map(registration, RegistrationDTO.class);
            String serviceId = registrationDTO.getServicesId();

            ClassDTO classDTO = classService.getByServiceId(serviceId);
            if (classDTO != null) {
                itemId = classDTO.getId();
                itemName = classDTO.getName();
            } else {
                PackageDTO packageDTO = packageService.getPackageByServiceId(serviceId);
                if (packageDTO != null) {
                    itemId = packageDTO.getId();
                    itemName = packageDTO.getName();
                } else {
                    PersonalTrainingDTO personalTrainingDTO = personalTrainingService.getPersonalTrainingByServiceId(serviceId);
                    itemId = personalTrainingDTO.getId();
                    itemName = personalTrainingDTO.getName();
                }
            }
            

            registrationDTO.setItemId(itemId);
            registrationDTO.setItemName(itemName);
            registrations.add(registrationDTO);
        });
        return registrations;
    }
}
