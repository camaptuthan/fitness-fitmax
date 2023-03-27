package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicesRepository extends JpaRepository<Services, String> {

    @Query("select s from Services s where s.serviceType.id = 1")
    List<Services> getServicesByPackage();

    @Query("select s from Services s where s.serviceType.id = 2")
    List<Services> getServicesByPT();

    @Query("select s from Services s where s.serviceType.id = 3")
    List<Services> getServicesByClass();

    @Query("select s from Services s join Status st on st.type = 'service' and s.status = st.type_id where s.serviceType.id = 1 and s.id = ?1")
    Services getPackageById(String id);


    @Query("select s from Services s where s.studio.id = ?1 and s.category.id = ?2")
    List<Services> getServicesByStudioIdAndCateId(String id,Long cat);

    @Query("select s from Services s where s.studio.id = ?1")
    List<Services> getServicesByStudio(String id);

    @Query("select s from Services s where s.id = ?1")
    List<Services> getServicesById(String id);




}
