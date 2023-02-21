package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entitties.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Long> {
    @Query(value = "Select * from fitmax.studio where city =:city", nativeQuery = true)
    public List<Studio> findStudio(@Param("city") String studioCity);

    @Query(value = "Select * from fitmax.studio where city = 'Hanoi'", nativeQuery = true)
    public List<Studio> findStudiosByStudioCity(@Param("city") String studioCity);

}
