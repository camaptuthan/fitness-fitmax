package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.entity.User;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public boolean registerUser(User user) {
        return userRepository.save(user) != null;
    }
}
