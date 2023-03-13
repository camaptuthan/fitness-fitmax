package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.entities.District;
import fivemonkey.com.fitnessbackend.entities.Studio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DistrictService {
    public List<District> findByCity(String id);
}
