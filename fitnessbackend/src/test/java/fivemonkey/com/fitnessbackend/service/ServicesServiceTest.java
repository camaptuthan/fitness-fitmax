package fivemonkey.com.fitnessbackend.service;

import fivemonkey.com.fitnessbackend.dto.ServicesDTO;
import fivemonkey.com.fitnessbackend.entities.*;
import fivemonkey.com.fitnessbackend.repository.ServiceTypeRepository;
import fivemonkey.com.fitnessbackend.repository.ServicesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
class ServicesServiceTest {

    @Autowired
    ServicesRepository servicesRepository;

    @Autowired
    ServicesService servicesService;

    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void getServiceByIdTC1() {
        Services services=servicesRepository.getServicesById("SER20230032");
        assertEquals("Practice KickBoxing for 3 months",services.getName());
        assertNotNull(services);
        System.out.println("Get Success");
    }
    @Test
    void getServiceByIdTC2() {
        Services services=servicesRepository.getServicesById("SER2023003000");
        assertNull(services);
        System.out.println("Get Fail");
    }

    @Test
    void addNewPackageTC1()  {
        ServicesDTO s= new ServicesDTO();
        s.setName("Yoga X 10 months ");
        s.setStatus(1);
        s.setPrice(1000F);
        s.setDate(new Date());
        s.setServiceTypeId(1L);
        s.setDuration(2);
        s.setCityId(1L);
        s.setStudioId("STU001");

        Services servicesExpected= new Services();
        servicesExpected.setPrice(s.getPrice());
        servicesExpected.setDuration(s.getDuration());
        servicesExpected.setName(s.getName());
        servicesExpected.setDate(s.getDate());
        servicesExpected.setId(s.getStudioId());
        servicesExpected.setServiceType(serviceTypeRepository.getServiceTypeById(s.getServiceTypeId()));
        Studio studio= new Studio();
        studio.setId("STU001");
        servicesExpected.setStudio(studio);

        City city= new City();
        city.setId(s.getCityId());
        servicesExpected.setCity(city);

        servicesRepository.save(servicesExpected);
        assertNotNull(servicesExpected);
        System.out.println("Insert successfully");

    }

    @Test
    void addNewPackageTC2()  {
        ServicesDTO s= new ServicesDTO();
        s.setName("Yoga X 10 months ");
        s.setStatus(1);
        s.setPrice(1F);
        s.setDate(new Date());
        s.setServiceTypeId(1L);
        s.setDuration(2);
        s.setCityId(1L);
        s.setStudioId("STU001");

        Services servicesExpected= new Services();
        servicesExpected.setPrice(s.getPrice());
        servicesExpected.setDuration(s.getDuration());
        servicesExpected.setName(s.getName());
        servicesExpected.setDate(s.getDate());
        servicesExpected.setId(s.getStudioId());
        servicesExpected.setServiceType(serviceTypeRepository.getServiceTypeById(s.getServiceTypeId()));
        Studio studio= new Studio();
        studio.setId("STU001");
        servicesExpected.setStudio(studio);
        City city= new City();
        city.setId(s.getCityId());
        servicesExpected.setCity(city);
        servicesRepository.save(servicesExpected);
        assertNotNull(servicesExpected);


    }
    @Test
    void addNewPackageTC3()  {
        ServicesDTO s= new ServicesDTO();
        s.setName("");
        s.setStatus(1);
        s.setPrice(1000F);
        s.setDate(new Date());
        s.setServiceTypeId(1L);
        s.setDuration(2);
        s.setCityId(1L);
        s.setStudioId("STU001");


        Services servicesExpected= new Services();
        servicesExpected.setPrice(s.getPrice());
        servicesExpected.setDuration(s.getDuration());
        servicesExpected.setName(s.getName());
        servicesExpected.setDate(s.getDate());
        servicesExpected.setId(s.getStudioId());
        servicesExpected.setServiceType(serviceTypeRepository.getServiceTypeById(s.getServiceTypeId()));
        Studio studio= new Studio();
        studio.setId("STU001");
        servicesExpected.setStudio(studio);

        City city= new City();
        city.setId(s.getCityId());
        servicesExpected.setCity(city);


        servicesRepository.save(servicesExpected);
        assertNotNull(servicesExpected);


    }

}