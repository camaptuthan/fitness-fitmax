package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.DistrictDTO;
import fivemonkey.com.fitnessbackend.entities.District;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DistrictService {
    List<DistrictDTO> getDistrictByCityId(Long id);

    District getDistrictByDistrictId(String id);
    District getDistrictByName(String name);

    District createDistrict(District district);

    District saveDistrict(District district);

    District getDistrictByCityAndDistrict(String city, String district);

    List<District> getNewDistrict(String city);

    List<DistrictDTO> getDistrictByCity(Long cityid, String keyword, int pageNumber);

    int totalPageDistrictByCity(Long cityid, String keyword);
}
