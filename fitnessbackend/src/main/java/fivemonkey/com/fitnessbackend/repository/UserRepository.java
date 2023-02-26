package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
//    List<User> findAllUserNameContaining(String email);
}
