package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.entities.District;
import fivemonkey.com.fitnessbackend.repository.DistrictRepository;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import fivemonkey.com.fitnessbackend.service.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;
    @Override
    public List<District> getDistrictById(String id) {
        return districtRepository.getDistrictsByCity(Long.valueOf(id));
    }

    @Override
    public District getDistrictByName(String name) {
        return districtRepository.getDistrictsByName(name);
    }

    @Override
    public District createDistrict(District district) {
        return districtRepository.save(district);
    }

    @Override
    public District saveDistrict(District district) {
        return districtRepository.save(district);
    }

    @Override
    public District getDistrictByCityAndDistrict(String city, String district) {
        return districtRepository.getDistrictsByCityAndDistrict(city, district);
    }

    @Override
    public List<District> getNewDistrict(String city) {
        return districtRepository.getDistrictsByCity(Long.valueOf(city));
    }

}
