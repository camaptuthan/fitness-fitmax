package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.Role;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import fivemonkey.com.fitnessbackend.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserRepository userRepository;
    @Override
    public void registerUser(String email,String password,String phone,String firstName,String lastName) {
        User user= new User();
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setStatus(true);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        Role r= new Role();
        r.setId(6L);
        user.setRole(r);
        Studio s= new Studio();
        s.setId(1L);
        user.setStudio(s);
        user.setDate(new Date());
        userRepository.save(user);

    }


    //check email exist ,phone may be optional
    @Override
    public List<Object> isUserPresent(UserDTO user) {
        boolean userExists = false;
        String message = null;
        Optional<User> existingUserEmail = userRepository.findByEmail(user.getEmail());
        if(existingUserEmail.isPresent()){
            userExists = true;
            message = "Email Already Present!";
        }
//        Optional<User> existingUserMobile = userRepository.findByMobile(user.getPhone());
//        if(existingUserMobile.isPresent()){
//            userExists = true;
//            message = "Mobile Number Already Present!";
//        }
//        if (existingUserEmail.isPresent() && existingUserMobile.isPresent()) {
//            message = "Email and Mobile Number Both Already Present!";
//        }
        System.out.println("existingUserEmail.isPresent() - "+existingUserEmail.isPresent());
        return Arrays.asList(userExists, message);
    }

    @Override
    public User login(UserDTO userDTO) {
        return userRepository.findByEmailAndPassword(userDTO.getEmail(),userDTO.getPassword()).orElse(null);
    }


}
