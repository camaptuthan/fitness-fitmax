package fivemonkey.com.fitnessbackend.service;
import com.mysql.cj.exceptions.DataReadException;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.repository.StudioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudioServiceTest {
    @Mock
    StudioRepository studioRepository;

    @InjectMocks
    StudioService studioService;
    @BeforeEach
    void setUp() {

    }
    @Test
    void getStudioByStudioId1() {


    }
    @Test
    void getStudioByStudioId() {
        String id="STU001";
        Studio s= new Studio();
        s.setName("Gym Ha Noi A");
        s.setId(id);
        when(studioRepository.findStudioById(id)).thenReturn(s);
        verify(studioRepository,times(1)).findStudioById("STU001");

    }

    @Test
    void saveStudioTC1() {

        Studio studioActual= new Studio("","Gym Fitness A","","","Ha Noi",new Date(),"",true,null,null,null);
        when(studioRepository.save(studioActual)).thenReturn(studioActual);
        studioService.saveStudio(studioActual);
        verify(studioRepository, times(1)).save(studioActual);

    }

    @Test
    void saveStudioTC2() {

    }
}