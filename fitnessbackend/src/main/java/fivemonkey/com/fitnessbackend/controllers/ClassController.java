package fivemonkey.com.fitnessbackend.controllers;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entitties.Clazz;
import fivemonkey.com.fitnessbackend.services.ClassService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping("/list-class")
    public String classes(Model model) {
        List<Clazz> classDTOList = classService.findAll();
        System.out.println("size is:" + classService.findAll().size());
        model.addAttribute("list", classDTOList);
        model.addAttribute("size", classDTOList.size());
        return "management/classmanagement/classlist";
    }

    //add class
    @GetMapping("add-class")
    public String addClass(Model model){

        return "management/classmanagement/classadd";
    }
}
