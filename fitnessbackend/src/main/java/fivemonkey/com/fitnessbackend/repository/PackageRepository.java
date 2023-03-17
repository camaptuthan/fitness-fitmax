package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<Package, String> {

    @Query("select p from Package p where concat(p.name,'',p.des,'',p.price,'',p.duration,'',p.date,'',p.services.category.name) like %?1%")
    List<Package> getAllInformationOfPackages(String keyword);

    @Query("select p.id,p.name,p.image,p.duration,p.price,p.des,p.status,p.services " +
            "from Package p join p.services s join s.category c " +
            "group by p.id")
    List<Package> getAllInformationOfPackage();

    Package getPackageByServicesId(String serviceId);

    @Query("select p from Package p where p.services.city.name = ?1")
    List<Package> getPackageByCity(String city_name);

    @Query("select p from Package p where p.services.city.name = ?1 and concat(p.name,'',p.des,'',p.price,'',p.duration,'',p.date) like %?2%")
    List<Package> getPackageByCityAndSearch(String city_name, String keyword);

    @Query("select p from Package p where p.services.studio_id = ?1")
    List<Package> getPackageByStudio(String id);

    @Query("select p from Package p where concat(p.name,'',p.des,'',p.price,'',p.duration,'',p.date) like %?1% " +
            "and p.services.studio_id = ?2 and p.services.category.name = ?3")
    List<Package> getPackageByStudioAndSearchAndCategory(String keyword, String studioid, String categoryname);

//    @Query("select p from Package p where " +
//            "concat(p.name,'',p.des,'',p.price,'',p.duration,'',p.date) like %?1% " +
//            "and p.services.city.name = ?2 " +
//            "and p.services.studio_id = ?3 " +
//            "and p.services.category.id = ?4")
//    List<Package> getPackageByFields(String keyword, String cityname, String studioId, String cateId);


}
