package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.Registration;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.entities.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, String> {

//    @Query(value = "select r from registration  r where r.service_id = :service_id", nativeQuery = true)
//    Registration getRegistrationByServiceIdAndTraineeId(@Param("service_id") String serviceId, @Param("user_email") String userEmail);

    Registration getRegistrationByServicesAndTrainee(Services service, Trainee trainee);

   // List<Registration> getRegistrationByTrainee(Trainee trainee);

    @Query(value = "select r from Registration r where r.trainee.email = :email")
    List<Registration> getRegistrationByTrainee(String email);
}
