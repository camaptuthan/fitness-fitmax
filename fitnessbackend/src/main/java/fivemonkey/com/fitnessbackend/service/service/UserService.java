package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.data.repository.query.Param;
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

    UserDTO getUserByEmail(String email);
    List<UserDTO> listUserByAdmin();

    List<UserDTO> findAllUser(String keyword);

    List<User> findAllUserNameContaining(String email);

    void updateUserAvatar(UserDTO userDTO);

    UserDTO  saveThumbnail(String thumbNail, String email);

    void registerUser(User user);

    void updateUser(UserDTO userDTO);
    void updateUserPassword(User user);



//    void updateUser(UserDTO userDTO);

    List<Object> isUserPresent(User user);

    void sendVerificationEmail(User u, String siteUrl) throws MessagingException, UnsupportedEncodingException;



    boolean verify(String code);


    void sendOTP(String email) throws MessagingException, UnsupportedEncodingException;;
    boolean verifyOTP(String email, String otp);



    void resetPassword(String email,String password);

    long countTrainer(String roleId);

    List<User> listAllTrainer(String role);
    public List<UserDTO> listUserByManage(String studioId,String keyword,String roleId);
    public List<UserDTO> listUserByAssistant(String studioId,String keyword,String roleId);


    List<UserDTO> getUserByFieldsByAdmin(
                                   @Param("keyword") String keyword,
                                   @Param("cityName") String cityName,
                                   @Param("roleId") String roleId,
                                   @Param("studioId") String studioId);


    List<UserDTO> getUserByFieldsByManager(
            @Param("email") String email,
            @Param("keyword") String keyword,
            @Param("roleId") String roleId);


    List<UserDTO> getUserByFieldsByAssistant(
            @Param("email") String email,
            @Param("keyword") String keyword,
            @Param("roleId") String roleId);


    List<User> getUserByRoleId(String roleId);

    User getManagerOfStudio(String id);

    User getUserById(Long id);
}
