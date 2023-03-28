package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.entities.Slider;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.imageuploader.ImageUploader;
import fivemonkey.com.fitnessbackend.repository.SliderRepository;
import fivemonkey.com.fitnessbackend.service.service.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/slider")
public class SliderController {
    @Autowired
    SliderService sliderService;
    @Autowired
    SliderRepository sliderRepository;

    @Autowired
    ImageUploader imageUploader;

    @GetMapping("/add")
    public String addSlider(Model model){
        Slider s= new Slider();
        model.addAttribute("s",s);
        return "/management/SliderManagement/add-slider";
    }
    @PostMapping("/add")
    public String addSliderDashboard(@ModelAttribute("s") Slider slider,@RequestParam("fileImage") MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String imageUrl = slider.getImage();
        if (fileName != null && !fileName.isEmpty()) {
            imageUrl = imageUploader.upload(file);
            slider.setImage(imageUrl);
        }else{
            slider.setImage("https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_default.jpg?alt=media&token=d96f81d3-65fc-43ac-be80-b8c9b6f55951");
        }
        sliderService.insertSlider(slider.getImage(),slider.getTitle(),slider.getDes());
        return "redirect:/slider/management";
    }
    @GetMapping("/management")
    public String getAllSlider( Model model) {
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
    public String saveEdit(@RequestParam("title") String title,@RequestParam("content") String content,@PathVariable("id") Long id,@RequestParam("fileImage") MultipartFile file){
        Slider slider= sliderService.findById(id);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String imageUrl = slider.getImage();
        if (fileName != null && !fileName.isEmpty()) {
            imageUrl = imageUploader.upload(file);
            slider.setImage(imageUrl);
        }else{
            slider.setImage("https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_default.jpg?alt=media&token=d96f81d3-65fc-43ac-be80-b8c9b6f55951");
        }
        slider.setTitle(title);
        slider.setDes(content);
        sliderRepository.save(slider);
        return "redirect:/slider/management";
    }




}
