package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.CityDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    List<CityDTO> getAllCity();

    CityDTO getCityByCityManager(String email);

    CityDTO getCityById(Long id);

    CityDTO getCityByAssistant(String email);

    CityDTO getCityByStudioManager(String email);
}
