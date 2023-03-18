package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.services.CityService;
import fivemonkey.com.fitnessbackend.services.StudioManagerService;
import fivemonkey.com.fitnessbackend.services.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/studio")
public class StudioController {
    @Autowired
    private StudioService studioService;
    @Autowired
    private CityService cityService;

    @Autowired
    private StudioManagerService studioManagerService;

    //Get Studio List
    @GetMapping("management/studios")
    public String listStudios(@AuthenticationPrincipal UserDetail userDetail, Model model) {
        if (userDetail.getUser().getRole().getName().equals("Admin")) {
            model.addAttribute("studios", studioService.getAllStudios());
        } else if (userDetail.getUser().getRole().getName().equals("City Manager")) {
            model.addAttribute("studios", studioService.getStudioByCity(userDetail.getUser().getCity().getName()));
        }
//        model.addAttribute("studios", studioService.getAllStudios());
        return "management/StudioManagement/studios";
    }

    //Add Studio
    @GetMapping("/management/addstudio")
    public String newStudio(Model model) {
       // List<StudioManager> mlist = studioManagerService.getAvailableManager();
        Studio studio = new Studio();
       // model.addAttribute("list", mlist);
        model.addAttribute("studio", studio);
        return "./management/StudioManagement/add_studio";
    }

    @GetMapping("/management/studios/{id}")
    public String deleteStudio(@PathVariable String id) {
        studioService.deleteStudioById(id);
        return "redirect:/studios";
    }

    //Update Studio Status
    @GetMapping("/statusstudios/{id}/{status}")
    public String updateStatus(@PathVariable String id, @PathVariable boolean status) {
        Studio studio = studioService.getStudioById(id);
        System.out.println("status: " + status);
        studio.setStatus(!status);

        studioService.saveStudio(studio);
        return "redirect:/studios";
    }

    @PostMapping("management/studioupdate/{id}")
    public String updateStudio(@PathVariable String id,
                               @ModelAttribute("studio") Studio studio,
                               Model model) {
        // get studio from database by id
        Studio existingStudio = studioService.getStudioById(id);
        existingStudio.setId(id);
        existingStudio.setName(studio.getName());
        existingStudio.setContact(studio.getContact());
        existingStudio.setDes(studio.getDes());
        existingStudio.setStatus(studio.isStatus());
        // save updated studio object
        studioService.updateStudio(existingStudio);
        return "redirect:/studios";
    }

    @GetMapping("management/studios/edit/{id}")
    public String editStudioForm(@PathVariable String id, Model model) {
        model.addAttribute("studio", studioService.getStudioById(id));
        return "management/StudioManagement/updatestudio";
    }

    @GetMapping("/management/studios/new")
    public String createStudioForm(Model model) {
     //   List<StudioManager> mlist = studioManagerService.getAvailableManager();
        Studio studio = new Studio();
      //  model.addAttribute("list", mlist);
        model.addAttribute("studio", studio);
        return "management/StudioManagement/addstudio";
    }

    @PostMapping("/management/poststudio")
    public String saveStudio( @ModelAttribute("studio") Studio studio) {
            studio.setStatus(true);
            studioService.saveStudio(studio);
            return "redirect:/studios";
    }


//    list studio in main

    @GetMapping("/studio-details/{id}")
    public String homepageStudioDetail(@PathVariable String id, Model model) {
        Studio s=  studioService.getStudioById(id);
        model.addAttribute("studio",s);
        return "/studio_details";
    }
}
