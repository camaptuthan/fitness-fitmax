package fivemonkey.com.fitnessbackend.service;

import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import fivemonkey.com.fitnessbackend.security.UserDetailService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserDetailService.class})
public class LoginServiceTest {

    @Autowired
    private UserDetailService loginService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testAuthenticateUser() {
        // Create mock user object
        User user = new User();
        user.setEmail("ducnvhe141646@fpt.edu.vn");
        user.setPassword("$2a$10$TYyzw5MwPzjO6W8ZvCCl/eJHsU9XsGgT/PYcQmQ1n7Jb45hLq3eyS"); // hashed password for "password"

        // Set up mock behavior for the UserRepository
        when(userRepository.findUserByEmail("ducnvhe141646@fpt.edu.vn")).thenReturn(user);

        // Call the authenticateUser method and assert the result
        UserDetails isAuthenticated = loginService.loadUserByUsername("ducnvhe141646@fpt.edu.vn");
//        assertTrue();
    }
}
