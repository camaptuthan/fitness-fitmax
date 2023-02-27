package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.services.IStudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudioController {
    @Autowired
    private IStudioService studioService;

    @PostMapping("/insertstudios")
    public void insertStudio(@RequestBody(required = false) Studio studio) {
        studioService.insertStudio(studio);
    }
    @GetMapping("/studios/{id}")
    public String deleteStudio(@PathVariable Long id) {
        studioService.deleteStudioById(id);
        return "redirect:/studios";
    }
    @GetMapping("/statusstudios/{id}/{status}")
    public String updateStatus(@PathVariable Long id, @PathVariable boolean status) {
        Studio studio = studioService.getStudioById(id);
        if(status = false){
            studio.setStatus(true);
        }
        else if(status = true) {
            studio.setStatus(false);
        }
        studioService.saveStudio(studio);
        return "redirect:/studios";
    }
    @PostMapping("/studios/{id}")
    public String updateStudio(@PathVariable Long id,
                                @ModelAttribute("studio") Studio studio,
                                Model model) {
        // get studio from database by id
        Studio existingStudio = studioService.getStudioById(id);
        existingStudio.setId(id);
//        existingStudio.setFirstName(studio.getFirstName());
        existingStudio.setName(studio.getName());
        existingStudio.setCity(studio.getCity());
        existingStudio.setDistrict(studio.getDistrict());
        existingStudio.setContact(studio.getContact());
        existingStudio.setDes(studio.getDes());
        //existingStudio.setStatus(studio);
        // save updated studio object
        studioService.updateStudio(existingStudio);
        return "redirect:/studios";
    }

    @GetMapping("/studios/edit/{id}")
    public String editStudioForm(@PathVariable Long id, Model model) {
        model.addAttribute("studio", studioService.getStudioById(id));
        return "management/StudioManagement/updatestudio";
    }

    @GetMapping("/findstudios")
    public List<Studio> findStudios(@RequestParam(name = "city") String studioCity) {
        return studioService.findStudio(studioCity);
    }

    @GetMapping("/studios")
    public String listStudios(Model model) {
        model.addAttribute("studios", studioService.getAllStudios());
        return "management/StudioManagement/studios";
    }

    @GetMapping("/studios/new")
    public String createStudioForm(Model model) {
        // create student object to hold student form data
        Studio studio = new Studio();
        model.addAttribute("studio", studio);
        return "management/StudioManagement/addstudio";
    }

    @PostMapping("/studios")
    public String saveStudio(@ModelAttribute("studio") Studio studio) {
        studioService.saveStudio(studio);
        return "redirect:/studios";
    }
}
