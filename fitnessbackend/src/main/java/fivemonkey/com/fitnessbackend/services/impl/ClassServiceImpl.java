package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.repository.ClassRepository;
import fivemonkey.com.fitnessbackend.services.ClassService;
import fivemonkey.com.fitnessbackend.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassRepository classRepository;
    @Autowired
    private ModelMapperConfiguration<Clazz, ClassDTO> modelMapperConfiguration;

    @Autowired
    private RegistrationService registrationService;

    //mapper class to class dto
    @Override
    public List<ClassDTO> findAll() {
        List<Clazz> clazzList = classRepository.findAll();
        return modelMapperConfiguration.mapList(clazzList, ClassDTO.class);
    }

    @Override
    public List<ClassDTO> findAllRelatedByClass(Clazz clazz) {
        return null;
    }

    @Override
    public Clazz save(ClassDTO c) {
        Clazz clazz = new Clazz();
//        clazz.setName(c.getName());
//        clazz.setPrice(c.getPrice());
//        clazz.setDes(c.getDes());
////        c.setServicesId(c.getServicesId());
//        // clazz.setTrainer(c.getTrainer());
//        clazz.setDate(new Date());
//        clazz.setStatus(true);
        return classRepository.save(clazz);
    }

    @Override
    public Clazz update(ClassDTO c) {
        try {
            Clazz clazz = classRepository.getById(c.getId());
//            clazz.setName(c.getName());
//            clazz.setPrice(c.getPrice());
//            clazz.setDes(c.getDes());
            // clazz.setService(c.getService());
            //  clazz.setTrainer(c.getTrainer());
            return classRepository.save(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }


    @Override


    public void disableClass(String id) {
        Clazz clazz = classRepository.getById(id);

//        clazz.setStatus(false);
        classRepository.save(clazz);
    }


    @Override

    public void enableById(String id) {
        Clazz clazz = classRepository.getById(id);
//        clazz.setStatus(true);
        classRepository.save(clazz);
    }

    // map dto
    @Override
    public ClassDTO getClassById(String id) {
        return modelMapperConfiguration.map(classRepository.getById(id), ClassDTO.class);
    }

    //paging
    @Override
    public Page<Clazz> pageClass(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return classRepository.findAll(pageable);
    }

    @Override
    public List<Clazz> searchByName(String keyword) {
        return null;
       // return classRepository.searchClassByKeyword(keyword);
    }

    @Override
    public ClassDTO getByServiceId(String id) {
        return modelMapperConfiguration.map(classRepository.getClazzByService(id), ClassDTO.class);
    }

    @Override
    public List<ClassDTO> getClassByUser(User user) {
        List<Clazz> clazzList = null;
        String id;
        switch (user.getRole().getId()) {
            case "ROLE0006":
                id = user.getCity().getName();
                clazzList = classRepository.findClazzByCityOrStudio(id);
                break;
            case "ROLE0002":
            case "ROLE0003":
                id = user.getStudio().getId();
                clazzList = classRepository.findClazzByCityOrStudio(id);
                break;
            default:
                clazzList = classRepository.findAll();
                break;
        }

        return modelMapperConfiguration.mapList(clazzList, ClassDTO.class);
    }

    @Override
    public Clazz addClassByUser(User user, ClassDTO classDTO) {
        return null;
    }

    //search
}
