package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.dto.TraineeDTO;
import fivemonkey.com.fitnessbackend.entities.Trainee;
import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, String> {
//    @Query("select t from Trainee t where t.statusSw =1 and t.citySwitch = :cityName")
//            List<Trainee> getTraineeSw(String cityName);

    @Query("SELECT t FROM Trainee t WHERE t.email =?1")
           Trainee getTraineeByEmail(String email);

//    @Query("SELECT t FROM Trainee t WHERE t.statusSw = 1")
//    List<Trainee> getTraineeByEmailByAdmin();




}


