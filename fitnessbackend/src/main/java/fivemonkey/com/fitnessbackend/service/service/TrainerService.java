package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.TrainerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainerService {

    List<TrainerDTO> getAllAvailableTrainersByStudio(String studioId);
    List<TrainerDTO> getListPT(String studioId);
    TrainerDTO getTrainerByEmail(String email);

    List<TrainerDTO> listAllPT();

    List<TrainerDTO> getListPTByCity(String cityName);

    List<TrainerDTO> getRandomPT();
}
