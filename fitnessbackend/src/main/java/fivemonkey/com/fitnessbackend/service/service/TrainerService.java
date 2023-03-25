package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.TrainerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainerService {

    List<TrainerDTO> getAllAvailableTrainers();
}
