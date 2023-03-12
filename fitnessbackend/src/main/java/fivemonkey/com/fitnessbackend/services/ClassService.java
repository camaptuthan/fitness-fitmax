package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ClassService {

    List<ClassDTO> findAll();

    List<ClassDTO> findAllRelatedByClass(Clazz clazz);

    Clazz save(ClassDTO c);

    Clazz update(ClassDTO c);


    void disableClass(String id);


    void enableById(String id);


    ClassDTO getClassById(String id);


    Page<Clazz> pageClass(int pageNo, int pageSize);


    List<Clazz> searchByName(String keyword);


    ClassDTO getByServiceId(String id);
}
