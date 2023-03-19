package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.StudioDTO;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.repository.StudioRepository;
import fivemonkey.com.fitnessbackend.service.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioServiceImpl implements StudioService {

    @Autowired
    private StudioRepository studioRepository;

    @Autowired
    private ModelMapperConfiguration<Studio, StudioDTO> modelMapper;

    @Override
    public List<StudioDTO> getAllStudios() {
        return modelMapper.mapList(studioRepository.findAll(), StudioDTO.class);
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
    public List<StudioDTO> getAllStudiosByCity(String cityname) {
        return modelMapper.mapList(studioRepository.findStudioByCityName(cityname), StudioDTO.class);
    }
}
