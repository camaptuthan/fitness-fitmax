package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.dto.StudioDTO;
import fivemonkey.com.fitnessbackend.entities.Studio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudioService {

    List<StudioDTO> getAllStudios();
    List<Studio> getAllStudio();
    StudioDTO getStudioByStudioManager(String email);

    StudioDTO getStudioById(String id);

    Studio getStudioByManagerId(String id);

    List<StudioDTO> getAllStudiosByCity(String cityname);


    List<StudioDTO> getAllByCity(String cityname);

    Long countStudio();
}
