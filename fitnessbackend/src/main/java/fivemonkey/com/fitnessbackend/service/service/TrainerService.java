package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.TrainerDTO;
import fivemonkey.com.fitnessbackend.entities.Trainer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainerService {

    List<TrainerDTO> getAllAvailableTrainers();
    List<TrainerDTO> getListPT(String studioId);
    TrainerDTO getTrainerByEmail(String email);
    Trainer getTrainerByEmail1(String email);

    List<TrainerDTO> listAllPT();

    List<TrainerDTO> getListPTByCity(String cityName);

    List<TrainerDTO> getRandomPT();

    TrainerDTO  setStatusTrainer(String email);
}
