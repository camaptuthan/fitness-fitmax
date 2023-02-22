package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.entities.Clazz;

import java.util.List;


public interface ClassService {
    List<Clazz> findAll();
    String save(Clazz c);
    Clazz update(Clazz c);

     void deleteClass(Long id);

    String enableById(Long id);
}
