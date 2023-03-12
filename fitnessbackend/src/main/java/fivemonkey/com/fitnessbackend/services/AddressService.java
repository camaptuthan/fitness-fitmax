package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.dto.DistrictDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    List<CityDTO> getCities();

    List<DistrictDTO> getDistrictsByCityId(Long cityId);
}
