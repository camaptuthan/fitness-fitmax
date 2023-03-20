package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.repository.ServicesRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ServiceServiceImplTest {


    @Autowired
//    ServiceService serviceService;

    ServicesRepository serviceRepository;
    @BeforeEach
//    void setUp() {
//        serviceService= new ServiceServiceImpl();
//    }

    @AfterEach
    void tearDown() {
    }

//    @Test
//    void getAll() {
//        List<Services> listClass=  serviceService.getAll();
//        Assertions.assertThat(listClass).isNotNull();
//    }

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