package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("select c from City c where c.cityManager.email = ?1")
    City getCityByCityManager(String email);

    @Query("select c from City c where c.districts = ?1")
    City getCityByDistrict(String districtid);

    @Query("select a.studio.district.city from Assistant a where a.email = ?1")
    City getCityByAssistant(String email);
}

