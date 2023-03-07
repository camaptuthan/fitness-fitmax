package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.entities.Manager;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.repository.ServiceRepository;
import fivemonkey.com.fitnessbackend.repository.StudioManagerRepository;
import fivemonkey.com.fitnessbackend.services.StudioManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudioManagerServiceImpl implements StudioManagerService{
    @Autowired
    StudioManagerRepository studioManagerRepository;
    @Override
    public List<Manager> getAll() {
     return studioManagerRepository.findAll();
    }

    @Override
    public List<Manager> getAvailableManager() {
        return studioManagerRepository.getAvailableManager();
    }
}

