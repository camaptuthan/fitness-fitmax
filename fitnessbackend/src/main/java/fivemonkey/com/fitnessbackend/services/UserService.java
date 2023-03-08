package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;


@Service
public interface UserService {
    List<UserDTO> findAll();

    User save(UserDTO u);

    User update(UserDTO u);

    void disableUser(String email);

    void enableById(String email);

    UserDTO getUserById(String email);

    List<UserDTO> findAllUser(String keyword);

    List<User> findAllUserNameContaining(String email);
    void registerUser(User user);

   

    void updateUser(UserDTO userDTO);

    List<Object> isUserPresent(User user);

    void sendVerificationEmail(User u, String siteUrl) throws MessagingException, UnsupportedEncodingException;



    boolean verify(String code);


}
