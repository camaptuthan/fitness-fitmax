package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Clazz, Long> {

    //paging
    @Query("select c from Clazz c where c.services.id = ?1")
    Clazz getClazzByServices(String servicesId);
}
