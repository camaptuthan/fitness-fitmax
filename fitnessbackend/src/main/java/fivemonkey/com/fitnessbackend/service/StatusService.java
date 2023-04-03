package fivemonkey.com.fitnessbackend.service;

import fivemonkey.com.fitnessbackend.entities.Status;
import fivemonkey.com.fitnessbackend.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

         
    public List<Status> getStatusByPackage() {
        return statusRepository.getStatusByPackage();
    }

         
    public List<Status> getStatusByClass() {
        return statusRepository.getStatusByClass();
    }

         
    public List<Status> getStatusByRegistration() {
        return statusRepository.getStatusByRegistration();
    }
}
