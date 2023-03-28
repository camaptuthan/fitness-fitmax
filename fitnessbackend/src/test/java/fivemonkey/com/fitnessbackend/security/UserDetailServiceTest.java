package fivemonkey.com.fitnessbackend.security;

import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserDetailService.class})
class UserDetailServiceTest {
    @Autowired
    private UserDetailService loginService;

    @MockBean
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void loadUserByUsername() {
        // Create mock user object
        User user = new User();
        user.setEmail("ducnvhe141646@fpt.edu.vn");
        user.setPassword("123456"); // hashed password for "password"
        when(passwordEncoder.matches("$2a$10$TYyzw5MwPzjO6W8ZvCCl/eJHsU9XsGgT/PYcQmQ1n7Jb45hLq3eyS", "123456")).thenReturn(true);
        // Set up mock behavior for the UserRepository
        when(userRepository.findByEmail("ducnvhe141646@fpt.edu.vn")).thenReturn(Optional.of(user));

        // Call
        UserDetails isAuthenticated = loginService.loadUserByUsername("ducnvhe141646@fpt.edu.vn");
        assertEquals("ducnvhe141646@fpt.edu.vn", isAuthenticated.getUsername());
    }

}