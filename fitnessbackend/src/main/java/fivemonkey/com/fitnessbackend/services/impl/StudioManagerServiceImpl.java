package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import fivemonkey.com.fitnessbackend.services.StudioManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudioManagerServiceImpl implements StudioManagerService{
    @Autowired
    private UserRepository  studioManagerRepository;

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> getAvailableManager() {
        return null;
    }

    @Override
    public User getStudioManagerByEmail(String email) {
        return null;
    }

//    @Override
//    public List<User> getAll() {
//        return studioManagerRepository.findAll();
//    }
//
//    @Override
//    public List<User> getAvailableManager() {
//        return studioManagerRepository.getAvailableManager();
//    }
//
//    @Override
//    public User getStudioManagerByEmail(String email) {
//        return studioManagerRepository.getById(email);
//    }

}

