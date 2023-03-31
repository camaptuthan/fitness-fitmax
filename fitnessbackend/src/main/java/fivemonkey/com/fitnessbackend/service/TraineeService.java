package fivemonkey.com.fitnessbackend.service;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.TraineeDTO;
import fivemonkey.com.fitnessbackend.entities.*;
import fivemonkey.com.fitnessbackend.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeService {
    @Autowired
    private TraineeRepository traineeRepository;
    @Autowired
    ModelMapperConfiguration<Trainee, TraineeDTO> modelMapperConfiguration;

       
    public List<TraineeDTO> getTraineeSw(String cityName) {
        return modelMapperConfiguration.mapList(traineeRepository.getTraineeSw(cityName), TraineeDTO.class);
    }

       
    public void changeStatusChangeSt(String email,String cityName ,String studioId, String serviceId) {
        Trainee trainee = traineeRepository.getTraineeByEmail(email);
        trainee.setStatusSw(1);
        trainee.setCitySwitch(cityName);
        trainee.setStudioSwitch(studioId);
        trainee.setServiceSwitch(serviceId);
        traineeRepository.save(trainee);
    }

       
    public TraineeDTO getTraineeByEmail(String email) {
        return modelMapperConfiguration.map(traineeRepository.getTraineeByEmail(email), TraineeDTO.class);
    }

       
    public void accpectSwichSt(TraineeDTO traineeDTO) {
        Trainee trainee = traineeRepository.getTraineeByEmail(traineeDTO.getEmail());
        trainee.setStatusSw(2);
        City city = new City();
        city.setName(traineeDTO.getCitySwitch());
//        trainee.getUser().setCity(city);

        traineeRepository.save(trainee);
    }

       
    public void rerejectSwichSt(TraineeDTO traineeDTO) {
        Trainee trainee = traineeRepository.getTraineeByEmail(traineeDTO.getEmail());
        trainee.setStatusSw(0);
        trainee.setCitySwitch("");
        trainee.setStudioSwitch("");
        traineeRepository.save(trainee);
    }

//
//       
//    public void rejectChangeSt(UserDTO userDTO) {
//        User user = userRepository.getUserByEmail(userDTO.getEmail());
//        user.setStatusChangeSt(0);
//        user.setStudioSt("");
//        userRepository.save(user);
//    }





}
