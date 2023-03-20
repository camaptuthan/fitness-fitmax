package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.entities.Registration;
import fivemonkey.com.fitnessbackend.repository.RegistrationRepository;
import fivemonkey.com.fitnessbackend.service.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;
    @Override
    public List<Registration> getAllRegistrations() {
        return null;
    }

    @Override
    public Registration getRegistrationById(String id) {
        return null;
    }

    @Override
    public void updateRegistration(Registration existingRegis) {

    }

    @Override
    public List<Registration> getRegistrationByManager(String studioId) {
        return registrationRepository.getRegistrationByManager(studioId);
    }

    @Override
    public List<Registration> getRegistrationByAssistant(String email) {
        return null;
    }
}
