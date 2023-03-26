package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.ServicesDTO;
import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.Services;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicesService {
    void updatePackageImg(ServicesDTO servicesDTO);

    ServicesDTO saveThumbnail(String thumbNail, String serviceId);

    List<ServicesDTO> getAllServices();

    List<ServicesDTO> getAllPackages();

    ServicesDTO getPackageDTOById(String id);

    Services getPackageById(String id);

    List<ServicesDTO> getAllClasses();

    List<ServicesDTO> getAllPTs();

    List<ServicesDTO> getPackagesBy3Fields(String keyword, String cityname, Long category);

    List<ServicesDTO> getPackagesBy4Fields(String keyword, String cityname, String studio, Long categoryLong);

    List<Services> getClassesByFields(String keyword, String cityname, String studio,Long category);

    List<Services> getPTsByFields(String keyword, String cityname, String studio,Long category);

    ServicesDTO getServiceById(String id);

    Services addNewPackage(ServicesDTO s);

    List<ServicesDTO> getServiceOfStudio(String id,Long cat);
    List<ServicesDTO> getAllServiceOfStudio(String id);
}
