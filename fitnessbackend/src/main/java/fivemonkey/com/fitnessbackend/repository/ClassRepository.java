package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entity.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Clazz,Long> {


}
