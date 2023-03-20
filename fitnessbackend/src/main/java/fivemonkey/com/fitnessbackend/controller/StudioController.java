package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.StudioDTO;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.service.service.CityService;
import fivemonkey.com.fitnessbackend.service.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/studio")
public class StudioController {
    @Autowired
    private StudioService studioService;
//    list studio in main

    @GetMapping("/studio-details/{id}")
    public String homepageStudioDetail(@PathVariable("id") String id, Model model) {
        StudioDTO s=  studioService.getStudioById(id);
        model.addAttribute("studio",s);
        return "/studio_details";
    }
}
