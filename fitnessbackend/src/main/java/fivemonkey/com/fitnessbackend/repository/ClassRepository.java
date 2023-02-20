package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entitties.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClassRepository  extends JpaRepository<Class,Long> {
//    @Query("SELECT c.name FROM Class c where c.id=1 ")
//    public Class getClassById();
}
