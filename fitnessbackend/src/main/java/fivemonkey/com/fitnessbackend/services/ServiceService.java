package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.entities.Services;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface ServiceService {

   List<Services> getAll();
}
