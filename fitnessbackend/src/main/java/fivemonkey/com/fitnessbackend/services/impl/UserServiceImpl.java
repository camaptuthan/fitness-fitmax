package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.dto.UserDTO;
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

import java.util.ArrayList;
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
        List<UserDTO>  userDTOList = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        for(User u : userList){
            UserDTO userDTO = mapper.map(u, UserDTO.class);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }




    @Override
    public User save(UserDTO u) {
        User user = new User();
        user.setStatus(true);
        return userRepository.save(user);
    }

    @Override
    public User update(UserDTO u) {
        try{
            User user = userRepository.getById(u.getEmail());
            Studio studio = new Studio();
            studio.setId(u.getStudioId());

            Role role = new Role();
            role.setId(u.getRoleId());

            user.setRole(role);
            user.setStudio(studio);
            System.out.println("=================================="+ user);


            return userRepository.save(user);
        }catch (Exception e){
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
    public UserDTO getUserById(String email) {
        User user = userRepository.getById(email);
        UserDTO userDTO = new UserDTO();
        ModelMapper mapper = new ModelMapper();
        userDTO = mapper.map(user, UserDTO.class);
        return userDTO;
    }



    @Override
    public List<User> findAllUser(String keyword) {
        if (keyword != null){
            return userRepository.findAllUser(keyword);
        }
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllUserNameContaining(String email) {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(UserDTO userDTO) {

        User user1  = userRepository.getById(userDTO.getEmail());
        user1.setAvatar(userDTO.getAvatar());
        userRepository.save(user1);

    }}


