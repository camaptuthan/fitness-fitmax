package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.StudioDTO;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.repository.StudioRepository;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import fivemonkey.com.fitnessbackend.service.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudioServiceImpl implements StudioService {

    @Autowired
    private StudioRepository studioRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapperConfiguration<Studio, StudioDTO> modelMapper;

//    @Override
//    public List<StudioDTO> getAllStudios() {
//        List<StudioDTO> studioDTOS = new ArrayList<>();
//        studioRepository.findAll().forEach(studio -> {
//            StudioDTO studioDTO = modelMapper.map(studio, StudioDTO.class);
//            String managerEmail = userRepository.listManagerByStudio(studio.getId());
//            studioDTO.setManagerEmail(managerEmail);
//            studioDTOS.add(studioDTO);
//        });
//        return studioDTOS;
//    }

    //remove
    @Override
    public List<StudioDTO> getAllStudios() {
        return modelMapper.mapList(studioRepository.findAll(), StudioDTO.class);
    }

    @Override
    public List<Studio> getAllStudio() {

        return studioRepository.findAll();
    }

    @Override
    public StudioDTO getStudioByStudioManager(String email) {

        return modelMapper.map(studioRepository.findStudioByStudioManager(email), StudioDTO.class);
    }

    @Override
    public StudioDTO getStudioById(String id) {
        return modelMapper.map(studioRepository.findStudioById(id), StudioDTO.class);
    }

    @Override
    public Studio getStudioByManagerId(String id) {
        return studioRepository.getStudioById(id);
    }

    @Override
    public List<StudioDTO> getAllStudiosByCity(String cityname) {
        return modelMapper.mapList(studioRepository.findStudioByCityName(cityname), StudioDTO.class);
    }

    @Override
    public List<StudioDTO> getAllByCity(String cityname) {
        return modelMapper.mapList(studioRepository.findStudioByCityName(cityname), StudioDTO.class);
    }

    @Override
    public Long countStudio() {
        return studioRepository.countStudio();
    }

}
