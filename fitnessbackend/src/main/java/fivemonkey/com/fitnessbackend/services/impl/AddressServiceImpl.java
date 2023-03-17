package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.dto.DistrictDTO;
import fivemonkey.com.fitnessbackend.dto.StudioDTO;
import fivemonkey.com.fitnessbackend.entities.City;
import fivemonkey.com.fitnessbackend.entities.District;
import fivemonkey.com.fitnessbackend.repository.CityRepository;
import fivemonkey.com.fitnessbackend.repository.DistrictRepository;
import fivemonkey.com.fitnessbackend.repository.StudioRepository;
import fivemonkey.com.fitnessbackend.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

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
    private ModelMapperConfiguration<District, StudioDTO> modelMapperStudio;
    @Override
    public List<CityDTO> getCities() {
        return modelMapperCity.mapList(cityRepository.findAll(), CityDTO.class);
    }

    @Override
    public List<DistrictDTO> getDistrictsByCityId(Long cityId) {
        return null;
      //  return modelMapperDistrict.mapList(districtRepository.getDistrictsByCity(cityId), DistrictDTO.class);
    }

//    @Override
//    public List<StudioDTO> getStudioByCity(Long cityId) {
//        return modelMapperStudio.mapList(studioRepository., DistrictDTO.class);
//    }
}
