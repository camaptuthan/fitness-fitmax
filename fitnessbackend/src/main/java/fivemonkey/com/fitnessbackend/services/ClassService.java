package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.entities.Role;
import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    List<ClassDTO> getClassByUser(User user);

    Clazz addClassByUser(User user, ClassDTO classDTO);
}
