package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.District;
import fivemonkey.com.fitnessbackend.entities.Studio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudioRepository extends JpaRepository<Studio, String> {
    @Query("select s.id, s.name from Studio s where s.district.id= :id")
    List<Studio> findByDistrict(@Param("id") String id);

    Page<Studio> findStudioByNameContaining(String name, Pageable pageable);

    @Query("select s from Studio s where s.district.city.name = ?1")
    List<Studio> findStudioByCityName(String cityname);
}
