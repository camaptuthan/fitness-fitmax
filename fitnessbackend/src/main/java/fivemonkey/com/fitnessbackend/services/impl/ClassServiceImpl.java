package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entitties.Clazz;
import fivemonkey.com.fitnessbackend.repository.ClassRepository;
import fivemonkey.com.fitnessbackend.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassRepository classRepository;

    @Override
    public List<Clazz> findAll() {
//        List<ClassDTO> classDTOList= new ArrayList<>();
//        List<Clazz> clazzList=classRepository.findAll();
//        for (Clazz c : clazzList){
//            ClassDTO classDTO= new ClassDTO();
//            classDTO.setId(c.getId());
//            classDTO.setDate(c.getDate());
//            classDTO.setName(c.getName());
//            classDTO.setPrice(c.getPrice());
//            classDTO.setImg(c.getImg());
//        }
//        return classDTOList;
         return classRepository.findAll();
    }

    @Override
    public Clazz save(Clazz c) {
        return null;
    }

    @Override
    public Clazz update(Clazz c) {
        return null;
    }

    @Override
    public Clazz delete(Long id) {
        return null;
    }

    @Override
    public Clazz enableById(Long id) {
        return null;
    }
}
