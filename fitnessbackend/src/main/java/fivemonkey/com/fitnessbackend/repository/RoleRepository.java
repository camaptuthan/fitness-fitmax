package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("SELECT r from Role r where r.id not in ('ROLE01')")
    List<Role> getRoleAdmin();


    @Query("SELECT r from Role r where r.id not in ('ROLE01','ROLE02')")
    List<Role> getRoleManager();

    @Query("SELECT r from Role r where r.id not in ('ROLE01','ROLE03','ROLE02')")
    List<Role> getRoleAssistant();}


