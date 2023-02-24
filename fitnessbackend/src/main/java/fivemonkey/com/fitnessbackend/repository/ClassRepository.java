package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Clazz,Long> {

    //paging
    @Query("select c from Clazz c")
    Page<Clazz> pageClass(Pageable pageable);


    @Query("select c from Clazz  c where c.name like %?1% or c.des like %?2%")
    Page<Clazz> searchClassByNameAndDes(String keyword,Pageable pageable);
}
