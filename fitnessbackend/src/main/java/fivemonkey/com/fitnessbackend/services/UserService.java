package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    void registerUser(String email,String password,String phone,String firstName,String lastName);
    public List<Object> isUserPresent(UserDTO user);

}
