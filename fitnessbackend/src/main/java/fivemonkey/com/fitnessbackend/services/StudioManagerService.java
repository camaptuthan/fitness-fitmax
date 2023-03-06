package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.entities.Manager;
import fivemonkey.com.fitnessbackend.entities.Services;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudioManagerService {
    List <Manager> getAll();
    @Query()
    List <Manager> getAvailableManager();
}
