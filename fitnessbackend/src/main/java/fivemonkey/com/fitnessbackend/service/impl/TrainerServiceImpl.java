package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.dto.TrainerDTO;
import fivemonkey.com.fitnessbackend.repository.TrainerRepository;
import fivemonkey.com.fitnessbackend.service.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;
    @Override
    public List<TrainerDTO> getAllAvailableTrainers() {
        return null;
    }
}
