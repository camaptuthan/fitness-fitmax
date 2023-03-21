package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.entities.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatusService {

    List<Status> getStatusByService();
}
