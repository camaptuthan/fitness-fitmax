package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.ServiceTypeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceTypeService {

    List<ServiceTypeDTO> getAll();

}
