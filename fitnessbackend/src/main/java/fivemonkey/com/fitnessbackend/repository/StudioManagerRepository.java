package fivemonkey.com.fitnessbackend.repository;


import fivemonkey.com.fitnessbackend.entities.StudioManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudioManagerRepository extends JpaRepository<StudioManager, String> {
@Query(value = "SELECT * FROM studio_manager where studio_manager_email " +
        "not in (Select studio_manager_email from studio)", nativeQuery = true)
    public List<StudioManager> getAvailableManager();


}
