package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.District;
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
//            "or u.studio.name like %?1%" +
            "or u.firstName like %?1%" +
            "or u.lastName like %?1%" )
    List<User> findAllUser(String keyword);
    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.phone=?1")
    Optional<User> findByMobile(String phone);

    @Query("SELECT u FROM User u where u.email LIKE %?1%")
    List<User> findAllUserNameContaining(String email);

    @Query("select u from User u where u.verificationCode=?1")
    User findByVerificationCode(String code);

//    @Query("select u from User u where u.role.id not in ('ROLE0001','ROLE0002','ROLE0006') and u.studioManager.studio.id = ?1")
//    List<User>listByManager(String studioId);
//
////    @Query("select u from User u where u.role.id not in ('ROLE0001','ROLE0006') and u.studio.district.city.name=?1")
//
//    @Query("select u from User u where u.role.id not in ('ROLE0001','ROLE0006') and u.city.name=?1")
//
//    List<User>listByCityAdmin(String city);
//    @Query("select u from User u where u.role.id not in ('ROLE0001','ROLE0003','ROLE0002','ROLE0006') and u.studioManager.studio.id = ?1")
//    List<User>listByAssistant(String studioId);

    //count trainer
    @Query("SELECT COUNT(u) FROM User u WHERE u.role.id=?1 ")
    long getCountOfTrainer(String role);
}
