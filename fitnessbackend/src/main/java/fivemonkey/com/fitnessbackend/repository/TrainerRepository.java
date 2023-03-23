package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.Trainer;
import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,String > {
    @Query(value = "select * from trainer t join user u on u.email = t.trainer_email where u.studio_id = ?1 ", nativeQuery = true)
    List<Trainer> getListPT(String studioId);


    @Query("SELECT t FROM Trainer t WHERE t.email =?1")
    Trainer getTrainerByEmail(String email);

    @Query(value = "select * from trainer t join user u on u.email = t.trainer_email join city c on u.city_id = c.city_id where c.city_name = ?1", nativeQuery = true)
    List<Trainer> getListPTByCity(String cityName);


}
