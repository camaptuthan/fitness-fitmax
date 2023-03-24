package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.ServicesDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassService {

    ClassDTO getByServiceId(String serviceId);

    List<ClassDTO> getAll();

    ClassDTO getClassById(String id);

    List<ClassDTO> getAllClass();

    List<ClassDTO> getClassesBy4Fields(String keyword, String cityname, String studio, Long category);
}
