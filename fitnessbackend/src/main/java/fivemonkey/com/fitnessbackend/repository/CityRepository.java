package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
