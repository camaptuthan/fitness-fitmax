package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.Clazz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Clazz, String> {

    //paging
    @Query("select c from Clazz c")
    Page<Clazz> pageClass(Pageable pageable);


    @Query("select c from Clazz  c where CONCAT(c.name,'',c.des,'',c.price) like %?1% ")
    List<Clazz> searchClassByKeyword(String keyword);


    @Query("select c from Clazz c where c.services.id = ?1")
    Clazz getClazzByService(String servicesId);

}
