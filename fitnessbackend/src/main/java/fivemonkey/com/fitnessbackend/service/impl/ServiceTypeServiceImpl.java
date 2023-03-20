package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.ServiceTypeDTO;
import fivemonkey.com.fitnessbackend.entities.ServiceType;
import fivemonkey.com.fitnessbackend.repository.ServiceTypeRepository;
import fivemonkey.com.fitnessbackend.service.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    @Autowired
    ModelMapperConfiguration<ServiceType, ServiceTypeDTO> modelMapper;
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceTypeDTO> getAll() {
        List<ServiceTypeDTO> list = new ArrayList<>();
        List<ServiceType> serviceTypes = serviceTypeRepository.findAll();
        for (ServiceType s : serviceTypes) {
            list.add(modelMapper.map(s, ServiceTypeDTO.class));
        }
        return list;
    }
}
