package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import fivemonkey.com.fitnessbackend.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserService.class})
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void registerUser() {
        User user = new User();
        user.setEmail("ducnvhe141646@fpt.edu.vn");
        user.setPassword("$2a$10$TYyzw5MwPzjO6W8ZvCCl/eJHsU9XsGgT/PYcQmQ1n7Jb45hLq3eyS"); // hashed password for "password"
        when(userRepository.findUserByEmail("ducnvhe141646@fpt.edu.vn")).thenReturn(null);
        userService.registerUser(user);
    }
}