package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.repository.ClassRepository;
import fivemonkey.com.fitnessbackend.services.ClassService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassRepository classRepository;


    //mapper class to class dto
    @Override
    public List<ClassDTO> findAll() {
        ModelMapper mapper= new ModelMapper();
        List<ClassDTO> classDTOList= new ArrayList<>();
        List<Clazz> clazzList=classRepository.findAll();
        for (Clazz c : clazzList){
            ClassDTO classDTO=mapper.map(c,ClassDTO.class);
            classDTOList.add(classDTO);
        }
        return classDTOList;

    }

    @Override
    public Clazz save(ClassDTO c) {
        Clazz clazz= new Clazz();
        clazz.setName(c.getName());
        clazz.setPrice(c.getPrice());
        clazz.setDes(c.getDes());
        clazz.setServices(c.getServices());
        clazz.setTrainer(c.getTrainer());
        clazz.setStatus(true);
        return classRepository.save(clazz);
    }

    @Override
    public Clazz update(ClassDTO c) {
        try{
            Clazz clazz=classRepository.getById(c.getId());
            clazz.setName(c.getName());
            clazz.setPrice(c.getPrice());
            clazz.setDes(c.getDes());
            clazz.setServices(c.getServices());
            clazz.setTrainer(c.getTrainer());
            return classRepository.save(clazz);
        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public void disableClass(Long id) {
        Clazz clazz=classRepository.getById(id);
        clazz.setStatus(false);
        classRepository.save(clazz);
    }


    @Override
    public void enableById(Long id) {
        Clazz clazz=classRepository.getById(id);
        clazz.setStatus(true);
        classRepository.save(clazz);
    }

    // map dto
    @Override
    public ClassDTO getClassById(Long id) {
        Clazz clazz= classRepository.getById(id);
        ClassDTO classDTO= new ClassDTO();
        ModelMapper mapper= new ModelMapper();
        classDTO=mapper.map(clazz,ClassDTO.class);
        return classDTO;
    }
}
