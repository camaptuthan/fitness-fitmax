package fivemonkey.com.fitnessbackend.service;

import fivemonkey.com.fitnessbackend.entities.Slider;
import fivemonkey.com.fitnessbackend.repository.SliderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SliderService {

    @Autowired
    SliderRepository sliderRepository;
          
    public List<Slider> getAllSlider() {
        return sliderRepository.findAll();
    }

          
    public void insertSlider(String img, String title,String image) {
        Slider slider= new Slider();
        slider.setDate(new Date());
        slider.setImage(img);
        slider.setTitle(title);
        sliderRepository.save(slider);
    }

          
    public void deleteSlider(Long id) {
        sliderRepository.deleteById(id);
    }

          
    public Slider findById(Long id) {
        return sliderRepository.findById(id).get();

    }


}
