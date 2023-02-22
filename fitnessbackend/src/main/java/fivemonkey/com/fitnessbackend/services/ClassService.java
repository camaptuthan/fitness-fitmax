package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;

import java.util.List;


public interface ClassService {
    List<ClassDTO> findAll();
    Clazz save(ClassDTO c);
    Clazz update(ClassDTO c);

     void disableClass(Long id);

    void enableById(Long id);


    ClassDTO getClassById(Long id);
}
