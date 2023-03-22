package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.dto.DistrictDTO;
import fivemonkey.com.fitnessbackend.dto.StudioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    List<CityDTO> getCities();

    List<DistrictDTO> getDistrictsByCityId(Long cityId);

    List<StudioDTO> getStudioByCity(String cityName);
}
