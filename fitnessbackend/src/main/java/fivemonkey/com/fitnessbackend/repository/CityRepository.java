package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Query("select c from City c where c.id = ?1")
    City getCityById(Long id);

    @Query("select c from City c where c.name = ?1")
    City getCityByName(String name);

    @Query("select u.studio.district.city from User u where u.email = ?1")
    City getCityByStudioManager(String email);

    @Query("select u.studio.district.city from User u where u.email = ?1")
    City getCityByAssistant(String email);

    @Query("select u.city from User u where u.email = ?1")
    City getCityByUser(String email);

    @Query(value = "select * from city", nativeQuery = true)
    List<City> getNewCity();
}

