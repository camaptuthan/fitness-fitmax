package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.dto.TrainerDTO;
import fivemonkey.com.fitnessbackend.repository.RegistrationRepository;
import fivemonkey.com.fitnessbackend.repository.TrainerRepository;
import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.entities.Trainer;
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

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public List<TrainerDTO> getListPT(String studioId) {

        return modelMapperConfiguration.mapList(trainerRepository.getListPT(studioId), TrainerDTO.class);

    }

    @Override
    public TrainerDTO getTrainerByEmail(String email) {

        return modelMapperConfiguration.map(trainerRepository.getTrainerByEmail(email), TrainerDTO.class);
    }

    @Override
    public Trainer getTrainerByEmail1(String email) {
        return trainerRepository.getTrainerByEmail(email);
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

    @Override
    public TrainerDTO setStatusTrainer(String email) {
        Trainer trainer = trainerRepository.getTrainerByEmail(email);
        if(registrationRepository.countRegistrationPT(email) == 3){
            trainer.setStatus(false);
        }
        System.out.println(registrationRepository.countRegistrationPT(email) );
        return modelMapperConfiguration.map(trainerRepository.save(trainer), TrainerDTO.class);
    }
}
