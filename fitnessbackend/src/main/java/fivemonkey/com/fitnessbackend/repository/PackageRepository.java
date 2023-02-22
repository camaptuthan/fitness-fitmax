package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entitties.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {

}
