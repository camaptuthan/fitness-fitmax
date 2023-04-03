package fivemonkey.com.fitnessbackend.service;
import fivemonkey.com.fitnessbackend.dto.TrainerDTO;
import fivemonkey.com.fitnessbackend.repository.RegistrationRepository;
import fivemonkey.com.fitnessbackend.repository.TrainerRepository;
import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.entities.Trainer;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService{

    @Autowired
    ModelMapperConfiguration<Trainer, TrainerDTO> modelMapperConfiguration;
    @Autowired
    private TrainerRepository trainerRepository;
    @Autowired
    private UserRepository userRepository;

      
    public List<TrainerDTO> getAllAvailableTrainersByStudio(String studioId) {
        return null;
    }

    @Autowired
    private RegistrationRepository registrationRepository;

      
    public List<TrainerDTO> getListPT(String studioId) {

        return modelMapperConfiguration.mapList(trainerRepository.getListPT(studioId), TrainerDTO.class);
    }

      
    public TrainerDTO getTrainerByEmail(String email) {

        return modelMapperConfiguration.map(trainerRepository.getTrainerByEmail(email), TrainerDTO.class);
    }

      
    public Trainer getTrainerByEmail1(String email) {
        return trainerRepository.getTrainerByEmail(email);
    }

      
    public List<TrainerDTO> listAllPT() {
        return modelMapperConfiguration.mapList(trainerRepository.getAllTrainer(), TrainerDTO.class);
    }

      
    public List<TrainerDTO> getListPTByCity(String cityName) {
        return modelMapperConfiguration.mapList(trainerRepository.getListPTByCity(cityName), TrainerDTO.class);
    }

      
    public List<TrainerDTO> getRandomPT() {
        return modelMapperConfiguration.mapList(trainerRepository.getRandomPT(), TrainerDTO.class);
    }

      
    public TrainerDTO setStatusTrainer(String email) {
        Trainer trainer = trainerRepository.getTrainerByEmail(email);
        if(registrationRepository.countRegistrationPT(email) == 3){
            trainer.setStatus(false);
        }
        System.out.println(registrationRepository.countRegistrationPT(email) );
        return modelMapperConfiguration.map(trainerRepository.save(trainer), TrainerDTO.class);
    }
}
