package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.TraineeDTO;
import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.Trainee;
import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TraineeService {
    List<TraineeDTO> getTraineeSw(String cityName);
    public void changeStatusChangeSt(String email,String cityName, String studioId, String serviceId, String serviceOld);
    TraineeDTO getTraineeByEmail(String email);

     void accpectSwichSt(TraineeDTO traineeDTO);

     void rerejectSwichSt(TraineeDTO traineeDTO);

    List<TraineeDTO> getTraineeSwByAdmin();


}
