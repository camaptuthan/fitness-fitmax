package fivemonkey.com.fitnessbackend.service;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.ServiceTypeDTO;
import fivemonkey.com.fitnessbackend.entities.ServiceType;
import fivemonkey.com.fitnessbackend.repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceTypeService {
    @Autowired
    ModelMapperConfiguration<ServiceType, ServiceTypeDTO> modelMapper;
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

            
    public List<ServiceTypeDTO> getAll() {
        return modelMapper.mapList(serviceTypeRepository.findAll(), ServiceTypeDTO.class);
    }

            
    public ServiceTypeDTO getServiceTypeById(Long id) {
        return modelMapper.map(serviceTypeRepository.getServiceTypeById(id), ServiceTypeDTO.class);
    }
}
