package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.RegistrationDTO;
import fivemonkey.com.fitnessbackend.entities.Registration;
import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegistrationService {
    List<RegistrationDTO> getRegistrationByUserEmail(String userEmail);
    RegistrationDTO doRegistration(User user, String itemId);
    boolean hasRegistration(String itemId, String userEmail);
    List<RegistrationDTO> getRegistrationsByUserEmail(String userEmail);
    List<Registration> getAllRegistrations();

    Registration getRegistrationById(String id);

    void updateRegistration(Registration existingRegis);

//    List<Registration> getRegistrationByManager(String studioId);

//    List<Registration> getRegistrationByAssistant(String email);
}
