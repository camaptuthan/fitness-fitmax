package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.entities.Registration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegistrationService {
    List<Registration> getAllRegistrations();

    Registration getRegistrationById(String id);

    void updateRegistration(Registration existingRegis);

    List<Registration> getRegistrationByManager(String studioId);

    List<Registration> getRegistrationByAssistant(String email);
}
