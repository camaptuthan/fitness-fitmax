package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.repository.ClassRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class ClassServiceTest {
    @InjectMocks
    private ClassService classService;

    @Mock
    private ClassRepository classRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        List<ClassDTO> listClass=  classService.findAll();
        Assertions.assertThat(listClass).isNotNull();
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }
}