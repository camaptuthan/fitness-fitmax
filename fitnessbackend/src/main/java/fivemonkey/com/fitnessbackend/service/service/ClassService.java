package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassService {

    ClassDTO getByServiceId(String serviceId);

    List<ClassDTO> getAll();
    List<ClassDTO> getByUserRole(User user);

    ClassDTO save(ClassDTO classDTO, User user);

    ClassDTO saveThumbnail(String thumbNail, String serviceId);
}
