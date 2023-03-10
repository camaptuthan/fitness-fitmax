package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.RegistrationDTO;
import fivemonkey.com.fitnessbackend.entities.Registration;
import fivemonkey.com.fitnessbackend.repository.RegistrationRepository;
import fivemonkey.com.fitnessbackend.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private ModelMapperConfiguration<Registration, RegistrationDTO> modelMapper;

    @Override
    public List<RegistrationDTO> getRegistrationByUserEmail(String userEmail) {
        List<Registration> registrations = registrationRepository.getRegistrationByTrainee(userEmail);
        if (registrations.isEmpty()) {
            //registration exception handling
            throw new NullPointerException();
        }
        return modelMapper.mapList(registrations, RegistrationDTO.class);
    }
}
