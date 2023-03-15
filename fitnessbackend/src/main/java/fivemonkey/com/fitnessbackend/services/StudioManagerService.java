package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.entities.StudioManager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudioManagerService {
    List <StudioManager> getAll();

    @Query()
    List<StudioManager> getAvailableManager();

    StudioManager getStudioManagerByEmail(String email);
}
