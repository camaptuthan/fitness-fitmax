package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudioManagerService {
    List <User> getAll();


    List<User> getAvailableManager();

    User getStudioManagerByEmail(String email);
}
