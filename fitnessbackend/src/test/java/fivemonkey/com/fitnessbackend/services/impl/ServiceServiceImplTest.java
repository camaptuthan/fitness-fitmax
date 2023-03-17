package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.repository.ServiceRepository;
import fivemonkey.com.fitnessbackend.services.ServiceService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ServiceServiceImplTest {


    @Autowired
    ServiceService serviceService;

    ServiceRepository serviceRepository;
    @BeforeEach
    void setUp() {
        serviceService= new ServiceServiceImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAll() {
        List<Services> listClass=  serviceService.getAll();
        Assertions.assertThat(listClass).isNotNull();
    }

    @Test
    void getAllByPackage() {
    }

    @Test
    void getAllByPT() {
    }

    @Test
    void getAllByClass() {
    }
}