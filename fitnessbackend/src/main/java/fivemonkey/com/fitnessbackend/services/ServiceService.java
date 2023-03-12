package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.ServiceDTO;
import fivemonkey.com.fitnessbackend.entities.Services;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface ServiceService {

   List<Services> getAll();

   List<ServiceDTO> getAllByPackage();

   List<ServiceDTO> getAllByPT();

   List<ServiceDTO> getAllByClass();
}
