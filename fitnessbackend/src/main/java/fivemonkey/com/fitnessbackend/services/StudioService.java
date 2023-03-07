package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.StudioDTO;
import fivemonkey.com.fitnessbackend.entities.Studio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface StudioService {

    void insertStudio(Studio studio);
    void deleteStudioById(String id);
//    List<Studio> findStudio(String studioCity);

    Studio getStudioById(String id);
    StudioDTO getStudioByIdd(String id);
    Studio updateStudio(Studio existingStudio);

    Studio updateStatus(long id, boolean status, Studio studio);

    List<Studio> getAllStudios();
    Studio saveStudio(Studio studio);
    Page<Studio> getALlByPage(int currentPage, String searchInput, String categoryId);
    Page<Studio> getStudioByPage(int currentPage, String searchInput);
    List<Studio> getAll();
    Studio save(Studio studio);
}
