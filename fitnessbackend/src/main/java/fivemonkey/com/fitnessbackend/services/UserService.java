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

    UserDTO getUserById(String email);


    List<User> findAllUser(String keyword);

    List<User> findAllUserNameContaining(String email);

    void updateUser(UserDTO userDTO);


}
