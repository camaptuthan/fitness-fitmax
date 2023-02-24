package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.repository.ClassRepository;
import fivemonkey.com.fitnessbackend.services.ClassService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassRepository classRepository;

    @Autowired
    ModelMapper modelMapper;

    //mapper class to class dto
    @Override
    public List<ClassDTO> findAll() {

        List<ClassDTO> classDTOList = new ArrayList<>();
        List<Clazz> clazzList = classRepository.findAll();
        for (Clazz c : clazzList) {
            ClassDTO classDTO = modelMapper.map(c, ClassDTO.class);
            classDTOList.add(classDTO);
        }
        return classDTOList;

    }

    @Override
    public Clazz save(ClassDTO c) {
        Clazz clazz = new Clazz();
        clazz.setName(c.getName());
        clazz.setPrice(c.getPrice());
        clazz.setDes(c.getDes());
        clazz.setServices(c.getServices());
        clazz.setTrainer(c.getTrainer());
        clazz.setDate(new Date());
        clazz.setStatus(true);
        return classRepository.save(clazz);
    }

    @Override
    public Clazz update(ClassDTO c) {
        try {
            Clazz clazz = classRepository.getById(c.getId());
            clazz.setName(c.getName());
            clazz.setPrice(c.getPrice());
            clazz.setDes(c.getDes());
            clazz.setServices(c.getServices());
            clazz.setTrainer(c.getTrainer());
            return classRepository.save(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public void disableClass(Long id) {
        Clazz clazz = classRepository.getById(id);
        clazz.setStatus(false);
        classRepository.save(clazz);
    }


    @Override
    public void enableById(Long id) {
        Clazz clazz = classRepository.getById(id);
        clazz.setStatus(true);
        classRepository.save(clazz);
    }

    // map dto
    @Override
    public ClassDTO getClassById(Long id) {
        Clazz clazz = classRepository.getById(id);
        ClassDTO classDTO = new ClassDTO();
        classDTO = modelMapper.map(clazz, ClassDTO.class);
        return classDTO;
    }

    //paging
    @Override
    public Page<Clazz> pageClass(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return classRepository.findAll(pageable);
    }

    @Override
    public List<ClassDTO> searchByName(String keyword) {

        List<ClassDTO> classDTOList= new ArrayList<>();
        List<Clazz> list = classRepository.searchClassByKeyword(keyword);
        for (Clazz c : list)
        {
            ClassDTO classDTO= new ClassDTO();
            modelMapper.map(c,ClassDTO.class);
            classDTOList.add(classDTO);
        }
        if (keyword != null) {
            return classDTOList;
        }

        return classDTOList;

    }
    //search


}
