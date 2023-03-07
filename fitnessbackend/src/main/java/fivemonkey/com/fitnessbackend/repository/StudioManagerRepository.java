package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudioManagerRepository extends JpaRepository<Manager, String> {
@Query(value = "SELECT * FROM manager where manager_email not in (\n" +
        "Select manager_email from studio )", nativeQuery = true)
    public List<Manager> getAvailableManager();
}
