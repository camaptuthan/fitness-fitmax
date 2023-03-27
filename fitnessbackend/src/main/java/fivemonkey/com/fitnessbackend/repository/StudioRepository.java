package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.dto.StudioDTO;
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

    @Query("select s from Studio s where s.district.city.name = ?1")
    List<Studio> findStudioByCityName(String cityname);

    @Query("select u.studio from User u where u.email = ?1")
    Studio findStudioByStudioManager(String email);

    @Query("select s from Studio s where s.id = ?1")
    Studio findStudioById(String id);

    //count studio
    @Query("SELECT COUNT(s) FROM Studio s  ")
    long countStudio();

    @Query("select s from Studio s where s.district.city.name= ?1")
    List<Studio> getStudioByCity(String cityName);

    //get studio by id
    @Query("SELECT s FROM Studio s WHERE s.id = ?1")
    Studio getStudioById(String id);
    @Query("select s, d.city.name from Studio s join District d where 1=1 and concat(s.contact,'',s.name,'',s.des,'',s.date) like '%\" + keyword + \"%' and s.district.id in (select d.id from District d where d.city.id = 1)")
    Studio findByName(String name);

    @Query("select s.id, s.name from Studio s where s.district.id = ?1")
    Studio findCityStudioByDistrict(Long id);

}
