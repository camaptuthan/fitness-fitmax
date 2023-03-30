package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.Registration;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.entities.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, String> {

//    @Query(value = "select r from registration  r where r.service_id = :service_id", nativeQuery = true)
//    Registration getRegistrationByServiceIdAndTraineeId(@Param("service_id") String serviceId, @Param("user_email") String userEmail);

    Registration getRegistrationByServicesAndTrainee(Services service, Trainee trainee);

    // List<Registration> getRegistrationByTrainee(Trainee trainee);


    @Query(value = "select r from Registration r join Status st on st.type = 'service' and r.status = st.type_id where r.trainee.email = :email order by r.services.date desc")
    List<Registration> getRegistrationByTrainee(String email);

    @Query(value = "SELECT r FROM Registration r join Services s where r.id = s.id and s.studio.id = :studioId")
    List<Registration> getRegistrationByManager(String studioId);

    @Query(value = "select r from Registration r join Status st on st.type = 'service' and r.status = st.type_id where r.services.user.email = :email")
    List<Registration> getRegistrationByAssistant(String email);

    @Query(value = "select r from Registration r where r.services.id = :id and r.trainee.email = :traineeEmail")
    Registration findRegistrationByServicesAndTrainee(String id, String traineeEmail);

    //change status
    @Query(value = "update Registration r set r.status = :status where r.id = :id")
    void updateStatus(String id, String status);

    @Query(value = "select r from Registration r join Status st on st.type = 'service' and r.status = st.type_id")
    List<Registration> getRegistrationByAdmin();


    @Query(value = "select r from Registration r where 1=1 and r.services.city.name =''")
    List<Registration> getRegistrationByCity(String city);

    @Query(value = "select r from Registration r where r.trainer.email= :trainerEmail and r.trainee.email = :traineeEmail")
    Registration findRegistrationByTrainerAndTrainee(String trainerEmail, String traineeEmail);

<<<<<<< HEAD
    @Query("select r from Registration r where r.trainer.email is not null and r.trainee.email is not null and r.trainer.user.studio.id = ?1 ")
    List<Registration> getRegistrationBookPt(String studioId);

    @Query("select count (r.id) from Registration r where r.trainer.email= :trainerEmail")
    int countRegistrationPT(String trainerEmail);

    @Query("select r from Registration r where r.trainee.email = :traineeEmail  and r.status = 1 and r.services.serviceType.id = 1")
    Registration getRegistrationByUser(String traineeEmail);

    @Query("select r from Registration  r where r.services.id = ?1")
    List<Registration> getRegistrationByServices(String serviceId);

=======
>>>>>>> a350894a12d3aff146ecd572a5ebbcb0c0356a89
}