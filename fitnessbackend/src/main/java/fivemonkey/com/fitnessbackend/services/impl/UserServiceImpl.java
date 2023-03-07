package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.entities.Role;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.repository.RoleRepository;
import fivemonkey.com.fitnessbackend.repository.StudioRepository;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import fivemonkey.com.fitnessbackend.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    StudioRepository studioRepository;


    @Override
    public List<UserDTO> findAll() {
        ModelMapper mapper = new ModelMapper();
        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        for (User u : userList) {
            UserDTO userDTO = mapper.map(u, UserDTO.class);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

//    @Override
//    public List<User> findAllUser() {
//        return userRepository.findAll();
//    }


    @Override
    public User save(UserDTO u) {
        User user = new User();
        user.setStatus(true);
        return userRepository.save(user);
    }

    @Override
    public User update(UserDTO u) {
        try {
            User user = userRepository.getById(u.getEmail());
            Studio studio = new Studio();
            studio.setId(u.getStudioId());

            Role role = new Role();
            // role.setId(u.getRoleId());

            user.setRole(role);
            user.setStudio(studio);
            System.out.println("==================================" + user);


            return userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void disableUser(String email) {
        User user = userRepository.getById(email);
        user.setStatus(false);
        userRepository.save(user);
    }

    @Override
    public void enableById(String email) {
        User user = userRepository.getById(email);
        user.setStatus(true);
        userRepository.save(user);

    }

    @Override
    public UserDTO getClassById(String email) {
        User user = userRepository.getById(email);
        UserDTO userDTO = new UserDTO();
        ModelMapper mapper = new ModelMapper();
        userDTO = mapper.map(user, UserDTO.class);
        return userDTO;
    }


    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllUserNameContaining(String email) {
        return userRepository.findAll();
    }


//    @Override
//    public List<UserDTO> findAllUserNameContaining(String email) {
//        ModelMapper mapper = new ModelMapper();
//        List<UserDTO>  userDTOList = new ArrayList<>();
//        List<User> userList = userRepository.findAllUserNameContaining(email);
//        for(User u : userList){
//            UserDTO userDTO = mapper.map(u, UserDTO.class);
//            userDTOList.add(userDTO);
//        }
//        return userDTOList;
//    }
}
