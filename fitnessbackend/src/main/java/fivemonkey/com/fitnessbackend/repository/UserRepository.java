package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
