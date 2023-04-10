package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.entities.Manager;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.services.StudioService;
import fivemonkey.com.fitnessbackend.services.StudioManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/studio")
public class StudioController {
    @Autowired
    private StudioService studioService;

    @Autowired
    private StudioManagerService studioManagerService;
    @GetMapping("/managestudio")
    public String studioAdmin() {
        return "management/StudioManagement/manage_studio";
    }

    @GetMapping("/sd")
    public String studioAdmind() {
        return "management/StudioManagement/add_studio";
    }

    @GetMapping("/sds")
    public String studioAdmindd() {
        return "management/StudioManagement/addstudio";
    }
    @PostMapping("/insertstudios")
    public void insertStudio(@RequestBody(required = false) Studio studio) {
        studioService.insertStudio(studio);
    }
    @GetMapping("/st")
    public String trainer(){
        return "management/StudioManagement/add_studio";
    }
    @GetMapping("/studios/{id}")
    public String deleteStudio(@PathVariable String id) {
        studioService.deleteStudioById(id);
        return "redirect:/studios";
    }

    @GetMapping("/statusstudios/{id}/{status}")
    public String updateStatus(@PathVariable String id, @PathVariable boolean status) {
        Studio studio = studioService.getStudioById(id);
        System.out.println("status: " + status);
        studio.setStatus(!status);

        studioService.saveStudio(studio);
        return "redirect:/studios";
    }

    @PostMapping("/studios/{id}")
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

    @GetMapping("/studios/edit/{id}")
    public String editStudioForm(@PathVariable String id, Model model) {
        model.addAttribute("studio", studioService.getStudioById(id));
        return "management/StudioManagement/updatestudio";
    }

    @GetMapping("/studios")
    public String listStudios(Model model) {
        model.addAttribute("studios", studioService.getAllStudios());
        return "management/StudioManagement/studios";
    }
//    @GetMapping("/studios/{pageNumber}")
//    public String getAllByPage(Model model,
//                              @RequestParam(value = "search ", defaultValue = "") String searchInput,
//                              @RequestParam(value = "city", defaultValue = "1") String city,
//                              @PathVariable(name = "pageNumber") int currentPage){
//        Page<Studio> page = studioService.getALlByPage(currentPage, searchInput, city);
//        long totalItems = page.getTotalElements();
//        int totalPages = page.getTotalPages();
//        List<Studio> listCourse = page.getContent();
//        List<Studio> listCourseRegister = new ArrayList<>();
//
//        model.addAttribute("listCourseRegister", listCourseRegister);
////        model.addAttribute("listCategory", categoryService.findAll());
////        model.addAttribute("query", "/?search=" + searchInput + "&category=" + categoryId);
////        model.addAttribute("currentCategoryId", categoryId);
//        model.addAttribute("currentSearch", searchInput);
//        model.addAttribute("currentPage", currentPage);
//        model.addAttribute("totalItems", totalItems);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("listCourse", listCourse);
//        return "management/StudioManagement/studio";
//    }
@GetMapping("/studiopage")
public String viewCourse(
                         Model model,
                         @RequestParam(value = "search", defaultValue = "") String searchInput,
                         @RequestParam(value = "category", defaultValue = "-1") Integer categoryId) {
    return getStudioByPage(model, searchInput, 1);
}
    @GetMapping("/studiopage/{pageNumber}")
    public String getStudioByPage(Model model,
                               @RequestParam(value = "search ", defaultValue = "") String searchInput,
                               @PathVariable(name = "pageNumber") int currentPage){
        Page<Studio> page = studioService.getStudioByPage(currentPage, searchInput);
        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List<Studio> listStudio = page.getContent();

//        model.addAttribute("query", "/?search=" + searchInput + "&category=" + categoryId);
//        model.addAttribute("currentCategoryId", categoryId);
        model.addAttribute("currentSearch", searchInput);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("query", "/?search=" + searchInput);
        model.addAttribute("listStudio", listStudio);
        return "management/StudioManagement/studio";
    }
    @GetMapping("/studios/new")
    public String createStudioForm(Model model) {
        List<Manager> mlist = studioManagerService.getAvailableManager();
        Studio studio = new Studio();
        model.addAttribute("list", mlist);
        model.addAttribute("studio", studio);
        return "management/StudioManagement/addstudio";
    }

    @PostMapping("/studios")
    public String saveStudio( @ModelAttribute("studio") Studio studio) {
            studio.setStatus(true);
            studioService.saveStudio(studio);
            return "redirect:/studios";

    }


//    list studio in main
    @GetMapping("/homepage/studio")
    public String listStudiosHomepage(Model model) {
        model.addAttribute("studios", studioService.getAllStudios());
        return "/studio";
    }
}
