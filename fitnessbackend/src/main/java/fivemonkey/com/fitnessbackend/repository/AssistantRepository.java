package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.Assistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistantRepository extends JpaRepository<Assistant, String> {

    @Query("select a.studio.id from Assistant a where a.email = ?1")
    String getStudioIdByAssistant(String email);
}
