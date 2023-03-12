package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Services, String> {

    @Query("select s from Services s where s.serviceType.id = 1")
    List<Services> getServicesByPackage();

    @Query("select s from Services s where s.serviceType.id = 2")
    List<Services> getServicesByPT();

    @Query("select s from Services s where s.serviceType.id = 3")
    List<Services> getServicesByClass();
}
