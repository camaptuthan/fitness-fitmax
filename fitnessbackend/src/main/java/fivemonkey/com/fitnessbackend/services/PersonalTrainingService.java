package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.PersonalTrainingDTO;
import org.springframework.stereotype.Service;

@Service
public interface PersonalTrainingService {

    PersonalTrainingDTO getPersonalTrainingByServiceId(String serviceId);
}
