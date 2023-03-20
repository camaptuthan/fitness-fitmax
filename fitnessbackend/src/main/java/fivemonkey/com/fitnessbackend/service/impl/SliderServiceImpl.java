package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.entities.Slider;
import fivemonkey.com.fitnessbackend.repository.SliderRepository;
import fivemonkey.com.fitnessbackend.service.service.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SliderServiceImpl implements SliderService {

    @Autowired
    SliderRepository sliderRepository;
    @Override
    public List<Slider> getAllSlider() {
        return sliderRepository.findAll();
    }
}
