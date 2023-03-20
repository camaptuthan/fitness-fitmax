package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.ServiceTypeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceTypeService {

    List<ServiceTypeDTO> getAll();

}
