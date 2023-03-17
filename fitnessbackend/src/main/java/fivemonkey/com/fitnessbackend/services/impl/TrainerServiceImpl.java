package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.entities.Trainer;
import fivemonkey.com.fitnessbackend.repository.TrainerRepository;
import fivemonkey.com.fitnessbackend.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    TrainerRepository trainerRepository;

    @Override
    public List<Trainer> getAll() {
        return trainerRepository.findAll();
    }
}
