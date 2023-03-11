package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.PersonalTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalTrainingRepository extends JpaRepository<PersonalTraining, String> {
    PersonalTraining findByServicesId(String serviceId);
}
