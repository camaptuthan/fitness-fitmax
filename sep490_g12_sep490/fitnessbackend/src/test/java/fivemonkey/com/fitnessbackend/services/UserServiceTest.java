package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class UserServiceTest {
    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
        List<User> users = userRepository.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        for (User u: users){
            System.out.println(u);
        }
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void disableUser() {
    }

    @Test
    void enableById() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void findAllUser() {
    }

    @Test
    void findAllUserNameContaining() {
    }

    @Test
    void updateUser() {
    }
}