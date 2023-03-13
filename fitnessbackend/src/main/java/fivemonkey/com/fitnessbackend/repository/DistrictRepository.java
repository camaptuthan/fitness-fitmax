package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface DistrictRepository extends JpaRepository<District,Long> {

    @Query("select d from District d where d.city.id = ?1")
    List<District> getDistrictsByCity(Long cityId);


}
