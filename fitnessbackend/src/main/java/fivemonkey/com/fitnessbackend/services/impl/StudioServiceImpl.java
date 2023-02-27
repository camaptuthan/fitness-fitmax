package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.repository.StudioRepository;
import fivemonkey.com.fitnessbackend.services.IStudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudioServiceImpl implements IStudioService {
   @Autowired
    private StudioRepository studioRepository;

    public void insertStudio(Studio studio) {
        studio.setDate(new Date());
        studioRepository.save(studio);
    }
    public void deleteStudioById(Long id) {
        studioRepository.deleteById(id);
    }

    public List<Studio> findStudio(String studioCity) {
        return studioRepository.findStudio(studioCity);
    }

    public List<Studio> findStudioCity(@Param("city") String studioCity) {
        return studioRepository.findStudiosByStudioCity(studioCity);
    }

    public Studio getStudioById(Long id) {
        return studioRepository.findById(id).get();
    }
    public void updateStudio(Studio existingStudio) {
    }

    @Override
    public Studio updateStatus(long id, boolean status, Studio studio) {
        if (status = true){
            studio.setStatus(false);
        }
        else {
            studio.setStatus(true);
        }
        studioRepository.save(studio);
        return studio;
    }

    @Override
    public List<Studio> getAllStudios() {
        return studioRepository.findAll();
    }

    @Override
    public Studio saveStudio(Studio studio) {
        studio.setDate(new Date(System.currentTimeMillis()));
        System.out.println(studio.getDate());
        return studioRepository.save(studio);
    }
}
