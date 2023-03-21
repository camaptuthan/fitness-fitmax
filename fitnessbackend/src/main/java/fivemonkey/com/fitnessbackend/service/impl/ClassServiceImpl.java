package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.repository.ClassRepository;
import fivemonkey.com.fitnessbackend.service.service.ClassService;
import fivemonkey.com.fitnessbackend.service.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassRepository classRepository;
    @Autowired
    private ModelMapperConfiguration<Clazz, ClassDTO> modelMapper;

    @Autowired
    private RegistrationService registrationService;

    @Override
    public ClassDTO getByServiceId(String serviceId) {
        return modelMapper.map(classRepository.getClazzByServices(serviceId), ClassDTO.class);
    }

    @Override
    public List<ClassDTO> getAll() {
        return modelMapper.mapList(classRepository.findAll(), ClassDTO.class);
    }

    @Override
    public List<ClassDTO> getByUserRole(User user) {
        List<Clazz> clazzes = user.getStudio() == null ? classRepository.findAll() : classRepository.getClazzByUserEmail(user.getEmail());
        assert clazzes != null;
        return modelMapper.mapList(clazzes, ClassDTO.class);
    }

    @Override
    public ClassDTO save(ClassDTO classDTO, User user) {
        Clazz clazz = classRepository.findById(classDTO.getId()).orElse(new Clazz());
        Services services = clazz.getServices();
        services.setName(classDTO.getServicesName());
        services.setDes(classDTO.getServicesDes());
        services.setStatus(classDTO.getServicesStatus());
        System.out.println(Arrays.toString(clazz.getSessions().toArray()));
        return modelMapper.map(classRepository.save(clazz),ClassDTO.class);
    }
}
