package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.ServicesDTO;
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
    private ModelMapperConfiguration<Services, ServicesDTO> mapper;

    @Override
    public List<Services> getAll() {
        return serviceRepository.findAll();
    }

    @Override
    public List<ServicesDTO> getAllByPackage() {
        List<ServicesDTO> list = new ArrayList<>();
        List<Services> list1 = serviceRepository.getServicesByPackage();
        for (Services s : list1) {
            list.add(mapper.map(s, ServicesDTO.class));
        }
        return list;
    }

    @Override
    public List<ServicesDTO> getAllByPT() {
        List<ServicesDTO> list = new ArrayList<>();
        List<Services> list1 = serviceRepository.getServicesByPT();
        for (Services s : list1) {
            list.add(mapper.map(s, ServicesDTO.class));
        }
        return list;
    }

    @Override
    public List<ServicesDTO> getAllByClass() {
        List<ServicesDTO> list = new ArrayList<>();
        List<Services> list1 = serviceRepository.getServicesByClass();
        for (Services s : list1) {
            list.add(mapper.map(s, ServicesDTO.class));
        }
        return list;
    }
}
