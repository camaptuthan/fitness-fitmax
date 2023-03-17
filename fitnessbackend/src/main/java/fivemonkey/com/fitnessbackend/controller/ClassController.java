package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.entities.Trainer;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.services.ClassService;
import fivemonkey.com.fitnessbackend.services.RegistrationService;
import fivemonkey.com.fitnessbackend.services.ServiceService;
import fivemonkey.com.fitnessbackend.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private TrainerService trainerService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private ClassService classService;
    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/management/list-class")
    public String classes(Model model, @Param("keyword") String keyword, @AuthenticationPrincipal UserDetail userDetail) {
        List<ClassDTO> classDTOList = classService.getClassByUser(userDetail.getUser());
        model.addAttribute("list", classDTOList);
//        model.addAttribute("size", classService.searchByName(keyword).size());
        return "management/classmanagement/classlist";
    }


    //show list trainer to add class
    //and list service to add
    //get information for class
    @GetMapping("/management/add-class")
    public String addClass(Model model) {
        List<Services> list = serviceService.getAll();
        model.addAttribute("list", list);
        model.addAttribute("clazz", new ClassDTO());
        return "management/classmanagement/classadd";
    }


    @PostMapping("/management/add-class")
    public String saveClass(@ModelAttribute("clazz") ClassDTO classDTO,
                            RedirectAttributes attributes) {
        try {
            classService.save(classDTO);
            attributes.addFlashAttribute("success", "Add successfully");

        } catch (Exception e) {
            attributes.addFlashAttribute("fail", "Add failed");
        }
        return "redirect:/class/management/list-class";
    }

    //enable class
    @RequestMapping(value = "/management/enable-class/{id}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String enableClass(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        classService.enableById(id);
        redirectAttributes.addFlashAttribute("success", "Enable Successfully");
        return "redirect:/class/management/list-class";

    }

    //disable class

    @RequestMapping(value = "/management/disable-class/{id}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String disableClass(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        classService.disableClass(id);
        redirectAttributes.addFlashAttribute("success", "Disabled");
        return "redirect:/class/management/list-class";
    }


    //get information of class
    @GetMapping("/management/update-class/{id}")
    public String getInformtionFormUpdate(@PathVariable("id") String id, Model model) {
        List<Trainer> trainerList = trainerService.getAll();
        ClassDTO clazzDTO = classService.getClassById(id);
        model.addAttribute("clazz", clazzDTO);
        model.addAttribute("listTrainer", trainerList);

        return "management/classmanagement/classedit";
    }


    @PostMapping("/management/update-class/{id}")
    public String processUpdate(@PathVariable("id") String id, @ModelAttribute("clazz") ClassDTO classDTO, RedirectAttributes redirectAttributes) {
        try {
            classService.update(classDTO);
            redirectAttributes.addFlashAttribute("success", "Update Successfully");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("fail", "Fail");
        }

        return "redirect:/class/management/list-class";
    }

    //paging class

    @GetMapping("page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;
        Page<Clazz> c = classService.pageClass(pageNo, pageSize);
        List<Clazz> list = c.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", c.getTotalPages());
        model.addAttribute("list", list);
        return "management/classmanagement/classlist";

    }

    @GetMapping("{id}")
    public String getDetail(@AuthenticationPrincipal UserDetail userDetail, @PathVariable("id") String id, Model model) {


        ClassDTO classDTO = classService.getClassById(id);
        List<ClassDTO> classDTOList = classService.findAll();

        Map<String, List<ClassDTO>> classDTOListMap = new HashMap<>();

        for (int i = 0; i < (classDTOList.size() / 3) + 1; i++) {
            List<ClassDTO> valueList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if (i * 3 + j < classDTOList.size()) {
                    valueList.add(classDTOList.get(i * 3 + j));
                }
            }
            classDTOListMap.put("page-" + i + 1, valueList);
        }


        boolean hasRegistered = false;
        if (userDetail != null) {
            hasRegistered = registrationService.hasRegistration(classDTO.getId(), userDetail.getUser().getEmail());
        }

        model.addAttribute("hasRegistered", hasRegistered);
        model.addAttribute("related_class", classDTOListMap);
        model.addAttribute("class", classDTO);


        return "class/profile";
    }
}
