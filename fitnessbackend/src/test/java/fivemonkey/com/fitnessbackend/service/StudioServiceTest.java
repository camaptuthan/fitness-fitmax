package fivemonkey.com.fitnessbackend.service;
import com.mysql.cj.exceptions.DataReadException;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.repository.StudioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
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

//        Studio studio = new Studio();
//        studio.setName("Yoga X");
//        studio.setStatus(true);
//        when(studioRepository.save(studio)).thenReturn(new Studio());
//        assertEquals("Yoga X",);
//        verify(studioRepository).save(studio);
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

        Studio studioExpected= new Studio();


        Studio studioActual= new Studio("","Gym Fitness A","","","Ha Noi",new Date(),"",true,null,null,null);
        when(studioRepository.save(studioActual)).thenReturn(studioExpected);
        studioService.saveStudio(studioExpected);
        verify(studioRepository, never()).save(studioActual);

    }

    @Test
    void saveStudioTC2() {
//        List<Studio> list= new ArrayList<>();
//        when(studioRepository.findAll()).thenReturn(list);
//        assertThrows(DataReadException.class,()->studioService.getAllStudio());

    }
}