package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.entity.Services;
import fivemonkey.com.fitnessbackend.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface ServiceService {

   List<Services> getAll();
}
