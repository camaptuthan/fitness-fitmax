package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.entity.Studio;
import fivemonkey.com.fitnessbackend.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioService {

    @Autowired
    StudioRepository studioRepository;

    public List<Studio> getStudios(){
        return studioRepository.findAll();
    }

    public boolean addStudio(Studio studio){
        return studioRepository.save(studio) !=null;
    }
    public void insertStudio(Studio studio){
        studioRepository.save(studio);
    }
    public void deleteStudio(Long id){
        studioRepository.deleteById(id);
    }

    public List<Studio> findStudio(String studioCity){
        return studioRepository.findStudio(studioCity);
    }
    public List<Studio> findStudioCity(@Param("city") String studioCity){
        return studioRepository.findStudiosByStudioCity(studioCity);
    }
//    public Studio updateStudio(Studio studio){
//        Studio s = studioRepository.findById(studio.getStudioID()).orElse(null);
//        s.setStudioCity(studio.getStudioCity());
//        s.setStudioDistrict(studio.getStudioDistrict());
//        s.setStudioRoad(studio.getStudioRoad());
//        s.setStudioName(studio.getStudioName());
//        s.setStudioContact(studio.getStudioContact());
//        s.setStudioDescription(studio.getStudioDescription());
//        return studioRepository.save(s);
//    }

}
