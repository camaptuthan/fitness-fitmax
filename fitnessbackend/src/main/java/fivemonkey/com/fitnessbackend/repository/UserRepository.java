package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.District;
import fivemonkey.com.fitnessbackend.entities.Registration;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("Select u from User u where u.email like %?1%" +
            "or u.address like %?1%" +
            "or u.role.name like %?1%" +
//            "or u.studioManager.studio.id like %?1%" +
            "or u.firstName like %?1%" +
            "or u.lastName like %?1%" +
            "and u.role.id not in('ROLE0001')"
    )
    List<User> findAllUser(String keyword);

    @Query("select u from User u where u.role.id not in('ROLE0001') ")
    List<User> listUserByAdmin();

    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.id=?1")
    Optional<User> findUserById(Long id);

    @Query("SELECT u FROM User u WHERE u.email =?1")
   User getUserByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.id=?1")
    User findUsersById(Long id);


    @Query("select u from User u where u.verificationCode=?1")
    User findByVerificationCode(String code);

    @Query("SELECT u.email FROM User u where u.role.name='Studio Manager' and u.studio.id=?1")
    String listManagerByStudio(String studioId);


    //count trainer
    @Query("SELECT COUNT(u) FROM User u WHERE u.role.id=?1 ")
    long getCountOfTrainer(String role);


    @Query("SELECT u FROM User u where u.role.id=?1")
    List<User> listAllTrainer(String role);


    @Query("SELECT u FROM User u WHERE u.email=?1")
    User findUserByEmail(String email);

    @Query("select s from Services s where s.studio.id =?1")
    List<Services> listServicesID(String studioId);

    @Query("select r from Registration r where r.services.id = ?1")
    List<Registration> getRegistration(String servicesId);

    @Query("select u from User u where  u.email =?1 and u.role.id not in('ROLE01','ROLE02')")
    List<User> getUserByManage(String email);

    @Query("select u from User u where  u.email =?1 and u.role.id not in('ROLE01','ROLE03','ROLE02')")
    List<User> getUserByAssistant(String email);



    @Query("Select u from User u where u.email like %?1%" +
            "or u.address like %?1%" +
            "or u.role.name like %?1%" +
//            "or u.studioManager.studio.id like %?1%" +
            "or u.firstName like %?1%" +
            "or u.lastName like %?1%" +
            "and u.role.id not in('ROLE0001')" +
            "and u.role.id = ?2" +
            "and u.city.name = ?3 " +
            "and u.studio.id=?4"
    )
    List<User> findAllUser(String keyword,String roleId, String cityName, String studioId);
}
