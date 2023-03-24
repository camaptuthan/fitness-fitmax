package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.entities.Slider;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.repository.SliderRepository;
import fivemonkey.com.fitnessbackend.service.service.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/slider")
public class SliderController {
    @Autowired
    SliderService sliderService;
    @Autowired
    SliderRepository sliderRepository;

    @GetMapping("/add")
    public String addSlider(Model model){
        Slider s= new Slider();
        model.addAttribute("s",s);
        return "/management/SliderManagement/add-slider";
    }
    @PostMapping("/add")
    public String addSliderDashboard(@ModelAttribute("s") Slider slider){
        sliderService.insertSlider(slider);
        return "redirect:/slider/management";
    }
    @GetMapping("/management")
    public String getAllServiceType( Model model) {
        List<Slider> sliderList=sliderService.getAllSlider();
        model.addAttribute("listSlider",sliderList);
        return "/management/SliderManagement/slider-list";
    }

    @GetMapping("/delete/{id}")
    public String deleteSlider(@PathVariable("id") Long id){
        sliderService.deleteSlider(id);
        return "redirect:/slider/management";
    }

    @GetMapping("/edit/{id}")
    public String editSlider(@PathVariable("id") Long id,Model model){
        Slider s= sliderService.findById(id);
        model.addAttribute("sliderInfo",s);
        return "/management/SliderManagement/edit-slider";

    }
    @PostMapping("/edit/{id}")
    public String saveEdit(@ModelAttribute("sliderInfo") Slider slider,@RequestParam("title") String title,@RequestParam("content") String content){
        slider.setTitle(title);
        slider.setDes(content);
        return "redirect:/slider/management";
    }




}
