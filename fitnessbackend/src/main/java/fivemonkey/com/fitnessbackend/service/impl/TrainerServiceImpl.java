package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.dto.TrainerDTO;
import fivemonkey.com.fitnessbackend.repository.TrainerRepository;
import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.TrainerDTO;
import fivemonkey.com.fitnessbackend.entities.Trainer;
import fivemonkey.com.fitnessbackend.repository.TrainerRepository;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import fivemonkey.com.fitnessbackend.service.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;
    @Override
    public List<TrainerDTO> getAllAvailableTrainers() {
        return null;
    }
    @Autowired
    ModelMapperConfiguration<Trainer, TrainerDTO> modelMapperConfiguration;
   
    @Autowired
   private UserRepository userRepository;

    @Override
    public List<TrainerDTO> getListPT(String studioId) {
        return modelMapperConfiguration.mapList(trainerRepository.getListPT(studioId), TrainerDTO.class);

    }

    @Override
    public TrainerDTO getTrainerByEmail(String email) {
        return modelMapperConfiguration.map(trainerRepository.getTrainerByEmail(email), TrainerDTO.class);
    }

    @Override
    public List<TrainerDTO> listAllPT() {
        return modelMapperConfiguration.mapList(trainerRepository.getAllTrainer(), TrainerDTO.class);
    }

    @Override
    public List<TrainerDTO> getListPTByCity(String cityName) {
        return modelMapperConfiguration.mapList(trainerRepository.getListPTByCity(cityName), TrainerDTO.class);
    }

    @Override
    public List<TrainerDTO> getRandomPT() {
        return modelMapperConfiguration.mapList(trainerRepository.getRandomPT(), TrainerDTO.class);
    }
}
