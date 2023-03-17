package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.controller.TrainerController;
import fivemonkey.com.fitnessbackend.dto.TrainerDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
class TrainerServiceImplTest {
    @InjectMocks
    TrainerController trainerController;


    @Mock
    TrainerServiceImpl trainerService;


    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAll() {
        Trainer t = new Trainer("ducnv@gmail.com", "1", "2", true);
        Trainer t2 = new Trainer("ducnv1@gmail.com", "1", "2", true);
        List<Trainer> trainerList = Arrays.asList(t, t2);
        when(trainerService.getAll()).thenReturn(trainerList);
        List<TrainerDTO> result = trainerController.getTrainers();
        assertEquals(result.size(), 2);
        assertEquals(trainerList, result);


//        List<Trainer> result = trainerService.getAll();
//        assertEquals("mocked response", result);
//      List<Trainer> listTrainer=  trainerService.getAll();
//      Assertions.assertThat(listTrainer).isNotNull();
    }

    @Test
    void getTrainerByEmail() {

    }
}