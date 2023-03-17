package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.services.CityService;
import fivemonkey.com.fitnessbackend.services.StudioManagerService;
import fivemonkey.com.fitnessbackend.services.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String listStudios(Model model) {
        model.addAttribute("studios", studioService.getAllStudios());
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

    //
//@GetMapping("/studiopage")
//public String viewStudioPage(
//                         Model model,
//                         @RequestParam(value = "search", defaultValue = "") String searchInput,
//                         @RequestParam(value = "category", defaultValue = "-1") Integer categoryId) {
//    return getStudioByPage(model, searchInput, 1);
//}
//    @GetMapping("/studiopage/{pageNumber}")
//    public String getStudioByPage(Model model,
//                               @RequestParam(value = "search ", defaultValue = "") String searchInput,
//                               @PathVariable(name = "pageNumber") int currentPage){
//        Page<Studio> page = studioService.getStudioByPage(currentPage, searchInput);
//        long totalItems = page.getTotalElements();
//        int totalPages = page.getTotalPages();
//        List<Studio> listStudio = page.getContent();
//
////        model.addAttribute("query", "/?search=" + searchInput + "&category=" + categoryId);
////        model.addAttribute("currentCategoryId", categoryId);
//        model.addAttribute("currentSearch", searchInput);
//        model.addAttribute("currentPage", currentPage);
//        model.addAttribute("totalItems", totalItems);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("query", "/?search=" + searchInput);
//        model.addAttribute("listStudio", listStudio);
//        return "management/StudioManagement/studio";
//    }
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


}
