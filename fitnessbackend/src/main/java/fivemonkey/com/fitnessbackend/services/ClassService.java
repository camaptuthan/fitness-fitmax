package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entitties.Clazz;

import java.util.List;


public interface ClassService {
    List<Clazz> findAll();
    Clazz save(Clazz c);
    Clazz update(Clazz c);

    Clazz delete(Long id);

    Clazz enableById(Long id);
}
