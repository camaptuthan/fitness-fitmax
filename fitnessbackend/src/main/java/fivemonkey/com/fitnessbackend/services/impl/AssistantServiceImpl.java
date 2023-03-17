package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.repository.AssistantRepository;
import fivemonkey.com.fitnessbackend.services.AssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssistantServiceImpl implements AssistantService {

    @Autowired
    private AssistantRepository assistantRepository;

    @Override
    public String getStudioIdByAssistant(String email) {
        return assistantRepository.getStudioIdByAssistant(email);
    }
}
