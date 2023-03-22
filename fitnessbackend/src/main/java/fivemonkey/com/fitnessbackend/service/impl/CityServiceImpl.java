package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.CategoryDTO;
import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.entities.Category;
import fivemonkey.com.fitnessbackend.entities.City;
import fivemonkey.com.fitnessbackend.repository.CityRepository;
import fivemonkey.com.fitnessbackend.service.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ModelMapperConfiguration<City, CityDTO> modelMapper;


    @Override
    public List<CityDTO> getAllCities() {
        return modelMapper.mapList(cityRepository.findAll(), CityDTO.class);
    }

    @Override
    public CityDTO getCityById(Long id) {
        return modelMapper.map(cityRepository.getCityById(id), CityDTO.class);
    }

    @Override
    public City getCityByName(String name) {
        return cityRepository.getCityByName(name);
    }

    @Override
    public CityDTO getCityByAssistant(String email) {
        return modelMapper.map(cityRepository.getCityByStudioManager(email), CityDTO.class);
    }

    @Override
    public CityDTO getCityByStudioManager(String email) {
        return modelMapper.map(cityRepository.getCityByStudioManager(email), CityDTO.class);
    }

    @Override
    public CityDTO getCityByUser(String email) {
        return modelMapper.map(cityRepository.getCityByUser(email), CityDTO.class);
    }
    @Override
    public List<CityDTO> getCities() {
        return modelMapper.mapList(cityRepository.findAll(), CityDTO.class);
    }
}
