package fivemonkey.com.fitnessbackend.services;
import fivemonkey.com.fitnessbackend.dto.UserDTO;

import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    List<UserDTO> findAll();

    User save(UserDTO u);
    User update(UserDTO u);
    void disableUser(String email);

    void enableById(String email);

    UserDTO getClassById(String email);
//    List<UserDTO> findAllUserNameContaining(String email);

}
