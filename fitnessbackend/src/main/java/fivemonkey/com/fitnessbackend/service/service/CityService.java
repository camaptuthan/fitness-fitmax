package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.entities.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    List<CityDTO> getAllCities();

    CityDTO getCityById(Long id);

    City getCityByName(String name);

    CityDTO getCityByAssistant(String email);

    CityDTO getCityByStudioManager(String email);

    CityDTO getCityByUser(String email);

    List<CityDTO> getCities();

    City saveCity(City city);

    City createCity(City city);

    List<City> getNewCity();

    List<City> getStudioCity(String cityName);

    List<City> getRegistrationCity();
}
