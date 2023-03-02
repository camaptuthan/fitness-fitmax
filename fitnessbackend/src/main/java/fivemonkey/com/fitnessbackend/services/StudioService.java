package fivemonkey.com.fitnessbackend.services;

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
    List<Studio> findStudio(String studioCity);

    Studio getStudioById(String id);

    void updateStudio(Studio existingStudio);

    Studio updateStatus(long id, boolean status, Studio studio);

    List<Studio> getAllStudios();
    Studio saveStudio(Studio studio);
//
//    List<Studio> findStudioCity(@Param("city") String studioCity);

    Page<Studio> getALlByPage(int currentPage, String searchInput, String categoryId);
    Page<Studio> getStudioByPage(int currentPage, String searchInput);
}
