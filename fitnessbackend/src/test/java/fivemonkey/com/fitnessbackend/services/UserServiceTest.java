package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

//    @InjectMocks
//    private UserService userService;

    @Test
    public void testGetUser() {
        String userId = "ducnvhe141646@fpt.edu.vn";
        User user = new User();
        user.setEmail("ducnvhe141646@fpt.edu.vn");
        user.setLastName("John");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));

//        UserDTO result = userService.getUserById(user.getEmail());

//        assertEquals(result, user);
//        verify(userRepository).findById(userId);
    }
}