package fivemonkey.com.fitnessbackend.service;
import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.entities.City;
import fivemonkey.com.fitnessbackend.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ModelMapperConfiguration<City, CityDTO> modelMapper;


        
    public List<CityDTO> getAllCities() {
        return modelMapper.mapList(cityRepository.findAll(), CityDTO.class);
    }

        
    public CityDTO getCityById(Long id) {
        return modelMapper.map(cityRepository.getCityById(id), CityDTO.class);
    }

        
    public City getCityByName(String name) {
        return cityRepository.getCityByName(name);
    }

        
    public CityDTO getCityByAssistant(String email) {
        return modelMapper.map(cityRepository.getCityByStudioManager(email), CityDTO.class);
    }

        
    public CityDTO getCityByStudioManager(String email) {
        return modelMapper.map(cityRepository.getCityByStudioManager(email), CityDTO.class);
    }

        
    public CityDTO getCityByUser(String email) {
        return modelMapper.map(cityRepository.getCityByUser(email), CityDTO.class);
    }
        
    public List<CityDTO> getCities() {
        return modelMapper.mapList(cityRepository.findAll(), CityDTO.class);
    }

        
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

        
    public City createCity(City city) {
        return cityRepository.save(city);
    }

        
    public List<City> getNewCity() {
        return cityRepository.getNewCity();
    }

        
    public List<City> getStudioCity(String cityName) {
        return cityRepository.getStudioCity(cityName);
    }

        
    public List<City> getRegistrationCity() {
        return cityRepository.getRegistrationCity();
    }
}
