package fivemonkey.com.fitnessbackend.service;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.dto.DistrictDTO;
import fivemonkey.com.fitnessbackend.dto.StudioDTO;
import fivemonkey.com.fitnessbackend.entities.City;
import fivemonkey.com.fitnessbackend.entities.District;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.repository.CityRepository;
import fivemonkey.com.fitnessbackend.repository.DistrictRepository;
import fivemonkey.com.fitnessbackend.repository.StudioRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private StudioRepository studioRepository;

    @Autowired
    private ModelMapperConfiguration<City, CityDTO> modelMapperCity;

    @Autowired
    private ModelMapperConfiguration<District, DistrictDTO> modelMapperDistrict;

    @Autowired
    private ModelMapperConfiguration<Studio, StudioDTO> modelMapperStudio;

    public List<CityDTO> getCities() {
        return modelMapperCity.mapList(cityRepository.findAll(), CityDTO.class);
    }


    public List<DistrictDTO> getDistrictsByCityName(String cityName) {
        return modelMapperDistrict.mapList(districtRepository.getDistrictByCityName(cityName), DistrictDTO.class);
    }


    public List<StudioDTO> getStudioByCity(String cityName) {
        return modelMapperStudio.mapList(studioRepository.getStudioByCity(cityName), StudioDTO.class);
    }
}
