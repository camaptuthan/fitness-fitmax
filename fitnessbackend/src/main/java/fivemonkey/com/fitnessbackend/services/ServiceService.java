package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.entitties.Services;
import fivemonkey.com.fitnessbackend.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Service
public class ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    public List<Services> getServices() {
        return serviceRepository.findAll();
    }

    public void addService(Services services){
        serviceRepository.save(services);
    }
}
