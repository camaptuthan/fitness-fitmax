package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.dto.StudioDTO;
import fivemonkey.com.fitnessbackend.entities.Studio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudioService {

    List<StudioDTO> getAllStudios();
    StudioDTO getStudioByStudioManager(String email);
    Studio getStudioById(String id);
    Studio getStudioByStudioId(String id);
    Studio getStudioByManagerId(String id);

    List<StudioDTO> getAllStudiosByCity(String cityname);
    List<StudioDTO> getAllStudiosByFilter(String keyword, String city, String status);
    Studio saveStudio(Studio studio);

    List<StudioDTO> getAllByCity(String cityname);

    Long countStudio();

    StudioDTO getStudioDTOByStudioId(String id);

    StudioDTO getStudioDTOById(String id);

    List<StudioDTO> getAllStudio();

}
