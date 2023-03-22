package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.entities.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Clazz, Long> {

    //paging
    @Query("select c from Clazz c where c.services.id = ?1")
    Clazz getClazzByServices(String servicesId);

    @Query("select c from Clazz c join Services s on c.services.id = s.id " +
            "join Status st on st.type = 'service' and c.services.status = st.type_id " +
            "where c.services.serviceType.id = 3 and c.services.id = ?1")
    Clazz getClassById(String id);

    @Query("select c from Clazz c join Services s on c.services.id = s.id " +
            "join Status st on st.type = 'service' and c.services.status = st.type_id " +
            "where c.services.serviceType.id = 3")
    List<Clazz> getAllClass();

}
