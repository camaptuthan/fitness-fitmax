package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<Package, String> {

    @Query("select p from Package p where concat(p.name,'',p.services.des,'',p.services.price,'',p.services.duration,'',p.services.date) like %?1%")
    List<Package> findAllPackage(String keyword);

    @Query("select p from Package p join p.services s join s.category c " +
            "where concat(p.name,'',p.services.des,'',p.services.price,'',p.services.duration,'',p.services.date,'',p.services.category.name) like %?1%")
    List<Package> getAllInformationOfPackages(String keyword);

    @Query("select p.id,p.name,p.services.image,p.services.duration,p.services.price,p.services.des,p.services.status,p.services " +
            "from Package p join p.services s join s.category c " +
            "group by p.id")
    List<Package> getAllInformationOfPackage();

    Package getPackageByServicesId(String serviceId);

    @Query("select p from Package p where p.services.city.name = ?1")
    List<Package> getPackageByCity(String city_name);

    @Query("select p from Package p where p.services.city.name = ?1 and concat(p.name,'',p.services.des,'',p.services.price,'',p.services.duration,'',p.services.date) like %?2%")
    List<Package> getPackageByCityAndSearch(String city_name, String keyword);

//    @Query("select p from Package p where p.services.studio.studioManager.email = ?1")
//    List<Package> getPackageByStudio(String email);

}
