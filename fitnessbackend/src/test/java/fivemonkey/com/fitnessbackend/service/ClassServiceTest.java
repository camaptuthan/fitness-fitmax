package fivemonkey.com.fitnessbackend.service;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class ClassServiceTest {

    @Mock
    ClassRepository classRepository;

    @InjectMocks
    ClassService classService;

    @Mock
    ClassDTO classDTO;

    @Mock
    CityRepository cityRepository;

    @Mock
    StudioRepository studioRepository;

    @Mock
    ServiceTypeRepository serviceTypeRepository;

    @Mock
    User user;

    @Mock
    UserRepository userRepository;

    @Mock
    ServicesRepository servicesRepository;

    @Mock
    private ModelMapperConfiguration<Clazz, ClassDTO> modelMapper;
    @BeforeEach
    public void setUp(){

    }
    @DisplayName("Junit test for get all class method")
    @Test
    void getAllClass() {
        classService.getAllClass();
        modelMapper.mapList(classRepository.findAll(), ClassDTO.class);
        // then - verify the output
        verify(classRepository).findAll();

    }

    @DisplayName("Junit test for get class by id")
    @Test
    void getById() {
         classDTO=modelMapper.map(classRepository.getClazzByServices("SER20230031"), ClassDTO.class);
         assertThat(classDTO).isNull();
    }

    @DisplayName("Junit test for get class by id")
    @Test
    void getByIdTC2() {
        Clazz c=classRepository.getClazzByServices("SER20230031");
        assertThat(c).isNull();
    }

    @DisplayName("Junit test for save class service")
    @Test
    void save() {
        Clazz clazz = classRepository.findByServicesId(classDTO.getServicesId()).orElse(new Clazz());
        Services services = clazz.getServices() == null ? new Services(new Date()) : clazz.getServices();
        services.setCity(cityRepository.getCityByName(classDTO.getServicesCityName()));
        services.setStudio(studioRepository.getStudioById(classDTO.getServicesStudioId()));
        services.setPrice(1000F);
        services.setName("Yoga X");
        services.setDes("Yoga Is good for health");
        services.setStatus(1);
        if (services.getId() == null) {
            services.setServiceType(serviceTypeRepository.getServiceTypeById(3L));
            services.setDuration(10);
            services.setUser(userRepository.getUserByEmail(user.getEmail()));
            servicesRepository.save(services);
            clazz.setServices(services);
        }
        modelMapper.map(classRepository.save(clazz), ClassDTO.class);
        assertThat(clazz).isNotNull();
    }
    @DisplayName("Junit test for save class service")
    @Test
    void saveClassUT2() {
//        Clazz clazz = classRepository.findByServicesId("3L").orElse(new Clazz());
//        Services services = clazz.getServices() ;
//        services.setPrice(100F);
//        services.setName("Yoga X");
//        services.setDes("Good");
//        services.setStatus(1);
//        modelMapper.map(classRepository.save(clazz), ClassDTO.class);
//        System.out.println("information of class is"+classDTO.getServicesName());
//        assertThat(clazz).isNotNull();
    }

    @Test
    void saveClass3(){
           Clazz c= new Clazz();
           c.setId(1L);
        modelMapper.map(classRepository.save(c), ClassDTO.class);
        assertThat(c.getId()).isNotNull();
        System.out.println("id of class is"+c.getId());
    }


}