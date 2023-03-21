package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.entities.Slider;
import fivemonkey.com.fitnessbackend.service.service.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/slider")
public class SliderController {
    @Autowired
    SliderService sliderService;

    @GetMapping("/add")
    public String addSlider(Model model){
        model.addAttribute("slider",new Slider());
        return "/management/SliderManagement/add-slider";
    }
    @GetMapping("/management")
    public String getAllServiceType( Model model) {
        List<Slider> sliderList=sliderService.getAllSlider();
        model.addAttribute("listSlider",sliderList);
        return "/management/SliderManagement/slider-list";
    }




}
