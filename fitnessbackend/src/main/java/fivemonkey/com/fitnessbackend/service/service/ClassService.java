package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.ServicesDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassService {

    ClassDTO getByServiceId(String serviceId);

    List<ClassDTO> getAll();
    List<ClassDTO> getByUserRole(User user,int currentPage,int size);

    ClassDTO save(ClassDTO classDTO, User user);

    ClassDTO saveThumbnail(String thumbNail, String serviceId);

    ClassDTO getClassById(String id);

    List<ClassDTO> getAllClass();

    List<ClassDTO> getClassesBy4Fields(String keyword, String cityname, String studio, Long category, int currentPage);

    int totalPageBy4Fields(String keyword, String cityname, String studio, Long category);

    default int getAllSize(){
        return this.getAll() == null ? 0 : this.getAll().size();
    };
}
