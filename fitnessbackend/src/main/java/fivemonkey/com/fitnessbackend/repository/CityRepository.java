package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("select c from City c where c.districts = ?1")
    City getCityByDistrict(String districtid);

}

