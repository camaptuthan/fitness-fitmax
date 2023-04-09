package fivemonkey.com.fitnessbackend.service;

import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService= new UserService();

    @Before("")
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void registerUser() {
        User user= new User();
        user.setPassword("12345");
        user.setEmail("ducnvhe141646@fpt.edu.vn");
        when(userRepository.save(user)).thenReturn(user);
        userService.registerUser(user);
        verify(userRepository,times(1)).save(user);


    }
}
