package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entitties.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Long> {
}
