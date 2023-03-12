package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.dto.ServiceTypeDTO;
import fivemonkey.com.fitnessbackend.entities.ServiceType;
import fivemonkey.com.fitnessbackend.repository.ServiceTypeRepository;
import fivemonkey.com.fitnessbackend.services.ServiceTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ServiceTypeDTO> getAll() {
        List<ServiceTypeDTO> list = new ArrayList<>();
        List<ServiceType> serviceTypes = serviceTypeRepository.findAll();
        for (ServiceType s: serviceTypes){
            list.add(modelMapper.map(s, ServiceTypeDTO.class));
        }
        return list;
    }
}
