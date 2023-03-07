package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.repository.StudioRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class IStudioServiceTest {
    @Autowired
    StudioRepository studioRepository;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insertStudio() {
    }

    @Test
    void deleteStudioById() {
    }

    @Test
    void getStudioById() {
    }

    @Test
    void getStudioByIdd() {

    }

    @Test
    void updateStudio() {
    }

    @Test
    void updateStatus() {
        String id ="STU0001";
        Studio studio = studioRepository.getById(id);
        System.out.println(" Status ID STU0001 before update:" + studio.isStatus());
        studio.setStatus(!studio.isStatus());
        Assertions.assertThat(studioRepository.save(studio)).isNotNull();
        System.out.println(" Status ID STU0001 before update:" + studio.isStatus());
    }

    @Test
    void getAllStudios() {
        List<Studio> studioList = studioRepository.findAll();
        System.out.println(studioList.size());
        Assertions.assertThat(studioList).isNotEmpty();
    }

    @Test
    void saveStudio() {
    }

    @Test
    void getALlByPage() {
    }

    @Test
    void getStudioByPage() {
    }
}