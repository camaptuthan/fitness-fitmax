package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.TrainerDTO;
import fivemonkey.com.fitnessbackend.entities.Trainer;
import fivemonkey.com.fitnessbackend.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;
    @GetMapping("/")
    public String trainer() {
        return "/trainer";
    }
    @GetMapping()
    public List<TrainerDTO> getTrainers(){
        List<TrainerDTO> trainerDTOS = new ArrayList<>();

        return trainerDTOS;
    }
}
