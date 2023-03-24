package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.RegistrationDTO;
import fivemonkey.com.fitnessbackend.entities.Registration;
import fivemonkey.com.fitnessbackend.entities.Status;
import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegistrationService {

    RegistrationDTO doRegistration(User user, String itemId);
    boolean hasRegistration(String serviceId, String userEmail);
    List<RegistrationDTO> getRegistrationsByUserEmail(String userEmail);

    List<Registration> getAllRegistrations();
    List<Registration> getAllRegistrationByAdmin();

    Registration getRegistrationById(String id);

    void updateRegistration(Registration existingRegis);


    List<Registration> getRegistrationByManager(String studioId);


    List<Registration> getRegistrationByAssistant(String email);

}
