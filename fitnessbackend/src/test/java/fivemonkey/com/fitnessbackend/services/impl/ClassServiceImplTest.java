package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.repository.ClassRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class ClassServiceImplTest {

    @Autowired
    ClassRepository classRepository;
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
        List<Clazz> list= classRepository.findAll();
        Assertions.assertThat(list).hasSizeGreaterThan(0);
        for (Clazz c: list){
            System.out.println(c.toString());
        }

    }

    // test case save 1 successfully
    @Test
    void save() {
        Clazz c = new Clazz();
        c.setName("yoga");
        c.setDes("a");
        c.setPrice(100F);
        Clazz clazzData=classRepository.save(c);
        Assertions.assertThat(clazzData).isNotNull();
        Assertions.assertThat(clazzData.getPrice()).isGreaterThan(90F);
        Assertions.assertThat(clazzData.getName()).isNotNull();

    }
    // test case save 2 successfully
    @Test
    void save2() {
        Clazz c = new Clazz();
        c.setName("erobic");
        c.setDes("b");
        c.setPrice(0F);
        Clazz clazzData=classRepository.save(c);
        Assertions.assertThat(clazzData).isNotNull();
        Assertions.assertThat(clazzData.getName()).isNotNull();

    }



    @Test
    void update() {
    }

    @Test
    void getClassById() {
    }

    @Test
    void searchByName() {
    }
}