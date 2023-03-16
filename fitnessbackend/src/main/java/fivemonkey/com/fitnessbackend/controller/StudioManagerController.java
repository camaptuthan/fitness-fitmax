package fivemonkey.com.fitnessbackend.controller;


import fivemonkey.com.fitnessbackend.entities.StudioManager;
import fivemonkey.com.fitnessbackend.services.StudioManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/studio")
@Controller
public class StudioManagerController {
    @Autowired
    private StudioManagerService studioManagerService;

    @GetMapping("/studiomanagers")
    public String listStudios(Model model) {
        model.addAttribute("studiomanagers", studioManagerService.getAll());
        return "management/StudioManagerManagement/studiomanagers";
    }

    @PostMapping("/studiomanagerupdate/{id}")
    public String updateStudio(@PathVariable String email,
                               @ModelAttribute("manager") StudioManager studiomanager,
                               Model model) {
        // get studio from database by id
        StudioManager existingManager = studioManagerService.getStudioManagerByEmail(email);

        existingManager.setUser(studiomanager.getUser());

//        existingStudio.setId(id);
//        existingStudio.setName(studio.getName());
//        existingStudio.setCity(studio.getCity());
//        existingStudio.setDistrict(studio.getDistrict());
//        existingStudio.setContact(studio.getContact());
//        existingStudio.setDes(studio.getDes());
//        existingStudio.setStatus(studio.isStatus());
//        // save updated studio object
//        studioService.updateStudio(existingStudio);
        return "redirect:/studios";
    }

    @GetMapping("/studiomanager/edit/{email}")
    public String editStudioForm(@PathVariable String email, Model model) {
        model.addAttribute("manager", studioManagerService.getStudioManagerByEmail(email));
        return "management/StudioManagerManagement/updatestudiomanager";
    }

    @GetMapping("/addstudiomanagers")
    public String studioDetails(Model model) {
        //List<Manager> mlist = studioManagerService.getAvailableManager();
        StudioManager manager = new StudioManager();
//        model.addAttribute("list", mlist);
        model.addAttribute("manager", manager);
        return "management/StudioManagerManagement/addstudiomanager";
    }
}
