package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.ServicesDTO;
import fivemonkey.com.fitnessbackend.entities.Services;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicesService {

    List<ServicesDTO> getAllServices();

    List<ServicesDTO> getAllPackages();

    List<ServicesDTO> getAllClasses();

    List<ServicesDTO> getAllPTs();

    List<Services> getPackagesBy3Fields(String keyword, String cityname, Long category);
    List<Services> getPackagesBy4Fields(String keyword, String cityname, String studio,Long category);

    List<Services> getClassesByFields(String keyword, String cityname, String studio,String category);

    List<Services> getPTsByFields(String keyword, String cityname, String studio,String category);

    ServicesDTO getServiceById(String id);

    Services save(ServicesDTO s);

    Services update(Services s);

    void disableService(String id);

    void enableService(String id);


}
