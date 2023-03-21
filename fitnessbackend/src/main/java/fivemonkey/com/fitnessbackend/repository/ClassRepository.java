package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Clazz, Long> {

    //paging
    @Query("select c from Clazz c where c.services.id = ?1")
    Clazz getClazzByServices(String servicesId);


    @Query("select s.clazz from Services s where s.studio.id is null or s.studio.id in (select u.studio.id from User u where u.email = ?1)")
    List<Clazz> getClazzByUserEmail(String studioManagerEmail);


}
