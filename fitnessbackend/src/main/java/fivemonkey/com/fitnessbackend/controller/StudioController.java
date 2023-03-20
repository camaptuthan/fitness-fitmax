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

//    list studio in homepage
    @GetMapping("/studio-details/{id}")
    public String homepageStudioDetail(@PathVariable("id") String id, Model model) {
        StudioDTO s=  studioService.getStudioById(id);
        model.addAttribute("studio",s);
        return "/studio_details";
    }

    @GetMapping("management/studios")
    public String listStudios(@AuthenticationPrincipal UserDetail userDetail, Model model) {
        if (userDetail.getUser().getRole().getName().equals("Admin")) {
            model.addAttribute("studios", studioService.getAllStudios());
        } else if (userDetail.getUser().getRole().getName().equals("Studio Manager")) {
            model.addAttribute("studio", studioService.getStudioByManagerId(userDetail.getUser().getStudio().getId()));
        }
        return "management/StudioManagement/studios";
    }

}
