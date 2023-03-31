package fivemonkey.com.fitnessbackend.service;

import fivemonkey.com.fitnessbackend.entities.District;
import fivemonkey.com.fitnessbackend.repository.DistrictRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService{
    @Autowired
    private DistrictRepository districtRepository;
      
    public List<District> getDistrictById(String id) {
        return districtRepository.getDistrictsByCity(Long.valueOf(id));
    }

      
    public District getDistrictByDistrictId(String id) {
        return districtRepository.getDistrictByDistrictId(Long.valueOf(id));
    }

      
    public District getDistrictByName(String name) {
        return districtRepository.getDistrictsByName(name);
    }

      
    public District createDistrict(District district) {
        return districtRepository.save(district);
    }

      
    public District saveDistrict(District district) {
        return districtRepository.save(district);
    }

      
    public District getDistrictByCityAndDistrict(String city, String district) {
        return districtRepository.getDistrictsByCityAndDistrict(city, district);
    }

      
    public List<District> getNewDistrict(String city) {
        return districtRepository.getDistrictsByCity(Long.valueOf(city));
    }

}
