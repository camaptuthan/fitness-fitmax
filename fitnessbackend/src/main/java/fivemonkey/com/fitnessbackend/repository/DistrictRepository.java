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

    @Query("select d from District d where d.name = ?1")
    District getDistrictsByName(String cityName);

    @Query("select d from District d where d.city.name = ?1 and d.name = ?2")
    District getDistrictsByCityAndDistrict(String city, String district);

    @Query(value = "select id, name from quanhuyen d where city_id = ?1", nativeQuery = true)
    List<District> getNewDistrictsByCity(Long cityId);

    @Query("select d from District d where d.city.name = ?1")
    List<District> getDistrictByCityName(String id);

    @Query("select d from District d where d.id = ?1")
    District getDistrictByDistrictId(Long id);
}
