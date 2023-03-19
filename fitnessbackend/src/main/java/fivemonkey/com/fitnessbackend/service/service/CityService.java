package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.CityDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    List<CityDTO> getAllCities();

    CityDTO getCityById(Long id);

    CityDTO getCityByStudioManager(String email);

    CityDTO getCityByUser(String email);
}
