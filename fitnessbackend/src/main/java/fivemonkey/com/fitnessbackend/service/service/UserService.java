package fivemonkey.com.fitnessbackend.service.service;

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

    void updateUserAvatar(UserDTO userDTO);

    void registerUser(User user);

    void updateUser(UserDTO userDTO);
    void updateUserPassword(User user);



//    void updateUser(UserDTO userDTO);

    List<Object> isUserPresent(User user);

    void sendVerificationEmail(User u, String siteUrl) throws MessagingException, UnsupportedEncodingException;



    boolean verify(String code);


    void sendOTP(String email) throws MessagingException, UnsupportedEncodingException;;
    boolean verifyOTP(String email, String otp);

    List<UserDTO>listByManager(String studioId);
    List<UserDTO>listByCityAdmin(String city);
    List<UserDTO>listByAssistant(String studioId);

    void resetPassword(String email,String password);

    long countTrainer(String roleId);

    List<User> listAllTrainer(String role);

    List<User> getUserByRoleId(String roleId);
}
