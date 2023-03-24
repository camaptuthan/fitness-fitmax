package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.entities.Slider;

import java.util.List;

public interface SliderService {
    List<Slider> getAllSlider();

    void insertSlider(Slider slider);

    void deleteSlider(Long id);

    Slider findById(Long id);
}
