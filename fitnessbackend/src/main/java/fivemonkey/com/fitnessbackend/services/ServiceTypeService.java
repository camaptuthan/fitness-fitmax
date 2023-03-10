package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.entities.ServiceType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceTypeService {

    List<ServiceType> getAll();

}
