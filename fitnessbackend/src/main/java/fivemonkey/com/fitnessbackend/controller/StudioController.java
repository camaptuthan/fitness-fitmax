package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.BlogDTO;
import fivemonkey.com.fitnessbackend.dto.CategoryDTO;
import fivemonkey.com.fitnessbackend.dto.ServicesDTO;
import fivemonkey.com.fitnessbackend.dto.StudioDTO;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/studio")
public class StudioController {
    @Autowired
    private StudioService studioService;
    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    ServicesService servicesService;

//    list studio in homepage
    @GetMapping("/studio-details/{id}")
    public String homepageStudioDetail(@RequestParam(value = "category", required = false, defaultValue = "0") Long category,@PathVariable("id") String id, Model model) {
        StudioDTO s=  studioService.getStudioDTOById(id);
        List<CategoryDTO> listCategory = categoryService.getAllCategoriesByType("service");
        Map<String, List<ServicesDTO>> packagesMapList = new HashMap<>();
        List<ServicesDTO> servicesDTOList;
        if(category==0){
            servicesDTOList=servicesService.getAllServiceOfStudio(id);
        }else{
            servicesDTOList=servicesService.getServiceOfStudio(id,category);
        }
        int size = servicesDTOList.size() % 3 == 0 ? servicesDTOList.size() / 3 : (servicesDTOList.size() / 3 + 1);
        List<ServicesDTO> value = null;
        for (int i = 0; i < size; i++) {
            value = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if (i * 3 + j < servicesDTOList.size()) {
                    value.add(servicesDTOList.get(i * 3 + j));
                }
            }
            packagesMapList.put("PKG-" + (i + 1), value);
        }
        model.addAttribute("studios",s);
        model.addAttribute("size", packagesMapList.size());
        System.out.println("size is "+packagesMapList.size());
        model.addAttribute("categoryList", listCategory);
        model.addAttribute("listServiceOfStudio",packagesMapList);
        model.addAttribute("currentCategory", category);
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

    //Add Studio
    @GetMapping("/management/addstudio")
    public String newStudio(Model model) {
         List<User> mlist = userService.getUserByRoleId("ROLE02");
        Studio studio = new Studio();
         model.addAttribute("list", mlist);
        model.addAttribute("studio", studio);
        return "./management/StudioManagement/add_studio";
    }
    //Update Studio Status
    @GetMapping("/management/statusstudios/{id}/{status}")
    public String updateStatus(@PathVariable String id, @PathVariable boolean status) {
        Studio studio = studioService.getStudioByStudioId(id);
        studio.setStatus(!status);
        studioService.saveStudio(studio);
        return "redirect:/studio/management/studios";
    }
    //Update Studio
    @GetMapping("management/studios/edit/{id}")
    public String editStudioForm(@PathVariable String id, Model model) {
        //StudioDTO studioDTO = studioService.getStudioById(id);
        model.addAttribute("studioDTO", studioService.getStudioDTOByStudioId(id));
        return "management/StudioManagement/updatestudio";
    }
    //Save Studio
    @PostMapping("/management/poststudio")
    public String saveStudio( @ModelAttribute("studio") Studio studio) {
        studio.setStatus(true);
        studioService.saveStudio(studio);
        return "redirect:/studio/management/studios";
    }

}
