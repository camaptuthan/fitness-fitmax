package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.StudioDTO;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.repository.StudioRepository;
import fivemonkey.com.fitnessbackend.services.StudioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudioServiceImpl implements StudioService {
   @Autowired
    private StudioRepository studioRepository;
    @Autowired
    ModelMapper modelMapper;
    public void insertStudio(Studio studio) {
        studio.setDate(new Date());
        studioRepository.save(studio);
    }
    public void deleteStudioById(String id) {
        studioRepository.deleteById(id);
    }

//    public List<Studio> findStudio(String studioCity) {
//        return studioRepository.findStudio(studioCity);
//    }

    @Override
    public Studio getStudioById(String id) {
        return studioRepository.findById(id).get();
    }
    @Override
    public StudioDTO getStudioByIdd(String id) {
        Studio studio = studioRepository.findById(id).get();

        StudioDTO studioDTO = new StudioDTO();
        studioDTO = modelMapper.map(studio, StudioDTO.class);

        return studioDTO;
    }
    public Studio updateStudio(Studio existingStudio) {
        try{
            Studio st = studioRepository.getById(existingStudio.getId());
            st.setName(existingStudio.getName());
            st.setContact(existingStudio.getContact());
            st.setDes(existingStudio.getDes());
            st.setStatus(existingStudio.isStatus());
            studioRepository.save(st);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Studio updateStatus(long id, boolean status, Studio studio) {
        studio.setStatus(!(status = true));
        studioRepository.save(studio);
        return studio;
    }

    @Override
    public List<Studio> getAllStudios() {
        return studioRepository.findAll();
    }

    @Override
    public Studio saveStudio(Studio studio) {
//        studio.setDate(new Date(System.currentTimeMillis()));
//        System.out.println(studio.getDate());
        return studioRepository.save(studio);
    }
    @Override
    public Page<Studio> getStudioByPage(int currentPage, String searchInput) {
        Pageable pageable = PageRequest.of(currentPage - 1, 6);
        if (searchInput == "") {
            return studioRepository.findAll(pageable);
        } else {
            return studioRepository.findStudioByNameContaining(searchInput, pageable);
        }
    }

    @Override
    public List<Studio> getAll() {
        return studioRepository.findAll();
    }

    @Override
    public Studio save(Studio studio) {
        return studioRepository.save(studio);
    }

    @Override
    public Page<Studio> getALlByPage(int currentPage, String searchInput, String categoryId) {
        Pageable pageable = PageRequest.of(currentPage - 1,6);
        if(categoryId=="1"){
            if(searchInput==""){
                return studioRepository.findAll(pageable);
            }
            else{
                return studioRepository.findStudioByNameContaining(searchInput,pageable);
            }
        }
        else if (searchInput==""){
//            return studioRepository.findStudioByCityOrderByIdDesc(categoryId,pageable);
            return studioRepository.findAll(pageable);
        }
        else
            //return studioRepository.findStudioByCategoryIdAndTitleContaining(categoryId,searchInput,pageable);
            return studioRepository.findAll(pageable);
    }
}
