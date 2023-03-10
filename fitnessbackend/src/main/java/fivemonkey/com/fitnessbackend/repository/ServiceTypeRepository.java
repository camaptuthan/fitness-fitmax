package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
}
