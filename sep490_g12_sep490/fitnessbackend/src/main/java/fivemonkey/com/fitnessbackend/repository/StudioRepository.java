package fivemonkey.com.fitnessbackend.repository;

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
//    @Query(value = "Select * from fitmax.studio where city =:city", nativeQuery = true)
//    public List<Studio> findStudio(@Param("city") String studioCity);

//    @Query(value = "Select * from fitmax.studio where city = 'Hanoi'", nativeQuery = true)
//    public List<Studio> findStudiosByStudioCity(@Param("city") String studioCity);

//    @Query(value = "Select * from fitmax.studio where city = 'Hanoi'", nativeQuery = true)
//    public void updateStatus(@Param("city") String studioCity);


    public Page<Studio> findStudioByNameContaining(String name, Pageable pageable);
//    public Page<Studio> findStudioByCityOrderByIdDesc(String city, Pageable pageable);

}
