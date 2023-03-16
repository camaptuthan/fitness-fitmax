package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.controller.TrainerController;
import fivemonkey.com.fitnessbackend.entities.Trainer;
import fivemonkey.com.fitnessbackend.repository.TrainerRepository;
import fivemonkey.com.fitnessbackend.services.TrainerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



class TrainerServiceImplTest {
    @Mock
    TrainerService trainerService;
     @InjectMocks
     private TrainerController trainerController;


     TrainerRepository trainerRepository;



    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAll() {
      List<Trainer> listTrainer=  trainerRepository.findAll();
      Assertions.assertThat(listTrainer).isNotNull();
    }
    @Test
    void getTrainerByEmail(){

    }
}