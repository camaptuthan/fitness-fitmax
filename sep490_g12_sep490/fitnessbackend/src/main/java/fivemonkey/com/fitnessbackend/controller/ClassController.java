package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.entities.Trainer;
import fivemonkey.com.fitnessbackend.services.ClassService;
import fivemonkey.com.fitnessbackend.services.ServiceService;
import fivemonkey.com.fitnessbackend.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ClassController {
    @Autowired
    TrainerService trainerService;
    @Autowired
    ServiceService serviceService;
    @Autowired
    private ClassService classService;


    @GetMapping("/list-class")
    public String classes(Model model, @Param("keyword") String keyword) {
        List<ClassDTO> classDTOList = classService.findAll();
        if (keyword == null) {
            model.addAttribute("list", classDTOList);
        } else {

            model.addAttribute("list", classService.searchByName(keyword));
        }
        model.addAttribute("size", classService.searchByName(keyword).size());
        return "management/classmanagement/classlist";
    }


    //show list trainer to add class
    //and list service to add
    //get information for class
    @GetMapping("/add-class")
    public String addClass(Model model) {
        List<Services> list = serviceService.getAll();
        model.addAttribute("list", list);
        model.addAttribute("clazz", new ClassDTO());
        return "management/classmanagement/classadd";
    }


    @PostMapping("/save-class")
    public String saveClass(@ModelAttribute("clazz") @Valid ClassDTO classDTO, BindingResult result,
                            RedirectAttributes attributes) {
        try {
            classService.save(classDTO);
            attributes.addFlashAttribute("success", "Add successfully");

        } catch (Exception e) {
            e.printStackTrace();
            attributes.addFlashAttribute("fail", "Add failed");
        }
        return "redirect:/admin/list-class";
    }

    //enable class
    @RequestMapping(value = "/enable-class/{id}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String enableClass(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
            classService.enableById(id);
            redirectAttributes.addFlashAttribute("success", "Enable Successfully");
            return "redirect:/admin/list-class";

    }

    //disable class

    @RequestMapping(value = "/disable-class/{id}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String disableClass(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
            classService.disableClass(id);
            redirectAttributes.addFlashAttribute("success", "Disabled");
            return "redirect:/admin/list-class";
    }


    //get information of class
    @GetMapping("/update-class/{id}")
    public String getInformtionFormUpdate(@PathVariable("id") String id, Model model) {
        List<Trainer> trainerList = trainerService.getAll();
        ClassDTO clazzDTO = classService.getClassById(id);
        model.addAttribute("clazz", clazzDTO);
        model.addAttribute("listTrainer", trainerList);

        return "management/classmanagement/classedit";
    }


    @PostMapping("/update-class/{id}")

    public String processUpdate(@PathVariable("id") String id, @ModelAttribute("clazz") ClassDTO classDTO, RedirectAttributes redirectAttributes) {
        try {
            classService.update(classDTO);
            redirectAttributes.addFlashAttribute("success", "Update Successfully");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("fail", "Fail");
        }

        return "redirect:/admin/list-class";
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


}
