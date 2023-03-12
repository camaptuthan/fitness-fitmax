package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.dto.ServiceDTO;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.repository.ServiceRepository;
import fivemonkey.com.fitnessbackend.services.ServiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<Services> getAll() {
        return serviceRepository.findAll();
    }

    @Override
    public List<ServiceDTO> getAllByPackage() {
        List<ServiceDTO> list = new ArrayList<>();
        List<Services> list1 = serviceRepository.getServicesByPackage();
        for (Services s : list1) {
            list.add(mapper.map(s, ServiceDTO.class));
        }
        return list;
    }

    @Override
    public List<ServiceDTO> getAllByPT() {
        List<ServiceDTO> list = new ArrayList<>();
        List<Services> list1 = serviceRepository.getServicesByPT();
        for (Services s : list1) {
            list.add(mapper.map(s, ServiceDTO.class));
        }
        return list;
    }

    @Override
    public List<ServiceDTO> getAllByClass() {
        List<ServiceDTO> list = new ArrayList<>();
        List<Services> list1 = serviceRepository.getServicesByClass();
        for (Services s : list1) {
            list.add(mapper.map(s, ServiceDTO.class));
        }
        return list;
    }
}
