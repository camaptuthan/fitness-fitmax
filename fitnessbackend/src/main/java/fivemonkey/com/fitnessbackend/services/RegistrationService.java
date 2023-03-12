package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.RegistrationDTO;
import fivemonkey.com.fitnessbackend.entities.Registration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegistrationService {
    List<RegistrationDTO> getRegistrationByUserEmail(String userEmail);
}
