package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("Select u from User u where u.email like %?1%" +
            "or u.address like %?1%" +
            "or u.role.name like %?1%" +
            "or u.studio.name like %?1%" +
            "or u.firstName like %?1%" +
            "or u.lastName like %?1%")
    public List<User> findAllUser(String keyword);
}
