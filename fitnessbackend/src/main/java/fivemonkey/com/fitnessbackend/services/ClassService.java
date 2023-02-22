package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.entity.Clazz;

import java.util.List;


public interface ClassService {
    List<Clazz> findAll();
    String save(Clazz c);
    Clazz update(Clazz c);



    String enableById(Long id);
}
