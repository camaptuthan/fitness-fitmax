package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.dto.PackageDTO;
import fivemonkey.com.fitnessbackend.entities.City;
import fivemonkey.com.fitnessbackend.entities.Package;
import fivemonkey.com.fitnessbackend.repository.CityRepository;
import fivemonkey.com.fitnessbackend.services.CityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    ModelMapperConfiguration<City, CityDTO> mapper;

    @Override
    public List<CityDTO> getAllCity() {
        return mapper.mapList(cityRepository.findAll(),CityDTO.class);
    }

    @Override
    public CityDTO getCityByCityManager(String email) {
        return null;
        // return mapper.map(cityRepository.getCityByCityManager(email), CityDTO.class);
    }

    @Override
    public CityDTO getCityById(Long id) {
        return mapper.map(cityRepository.getById(id), CityDTO.class);
    }

    @Override
    public CityDTO getCityByAssistant(String email) {
        return null;
        //  return mapper.map(cityRepository.getCityByAssistant(email), CityDTO.class);
    }
}
