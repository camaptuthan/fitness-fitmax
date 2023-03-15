package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.RegistrationDTO;
import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegistrationService {

    boolean hasRegistration(String itemId, String userEmail);
    List<RegistrationDTO> getRegistrationsByUserEmail(String userEmail);

    RegistrationDTO doRegistration(User user, String itemId);
}
