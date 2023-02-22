package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.entities.Trainer;
import fivemonkey.com.fitnessbackend.repository.ClassRepository;
import fivemonkey.com.fitnessbackend.services.ClassService;
import fivemonkey.com.fitnessbackend.services.ServiceService;
import fivemonkey.com.fitnessbackend.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ClassController {
    @Autowired
    private ClassService classService;


    @Autowired
    TrainerService trainerService;


    @Autowired
    ServiceService serviceService;

    @GetMapping("/list-class")
    public String classes(Model model) {
        List<ClassDTO> classDTOList = classService.findAll();
        model.addAttribute("list", classDTOList);
        model.addAttribute("size", classDTOList.size());
        return "management/classmanagement/classlist";
    }


    //show list trainer to add class
    //and list service to add
    //get information for class
    @GetMapping("/add-class")
    public String addClass(Model model){
        List<Trainer> trainerList=trainerService.getAll();
        List<Services> list=serviceService.getAll();
        model.addAttribute("list",list);
        model.addAttribute("listTrainer",trainerList);
        model.addAttribute("clazz", new ClassDTO());
        return "management/classmanagement/classadd";
    }


    @PostMapping("save-class")
    public String saveClass(@ModelAttribute("clazz") ClassDTO classDTO,
                            RedirectAttributes attributes){
        try {
                classService.save(classDTO);
                attributes.addFlashAttribute("success","Add successfully");

        }catch (Exception e){
              e.printStackTrace();
            attributes.addFlashAttribute("fail","Add failed");
        }
        return "redirect:/list-class";
    }

    //enable class
    @RequestMapping(value="/enable-class/{id}",method = {RequestMethod.PUT,RequestMethod.GET})
    public String enableClass(@PathVariable("id") Long id,RedirectAttributes redirectAttributes){
           try{
               classService.enableById(id);
               redirectAttributes.addFlashAttribute("success","Enable Successfully");
           }catch (Exception e){
               e.printStackTrace();
               redirectAttributes.addFlashAttribute("fail","Fail to enabled");
           }
           return "redirect:/list-class";
    }

    //disable class

    @RequestMapping(value="/disable-class/{id}",method = {RequestMethod.PUT,RequestMethod.GET})
    public String disableClass(@PathVariable("id") Long id,RedirectAttributes redirectAttributes){
        try{
            classService.disableClass(id);
            redirectAttributes.addFlashAttribute("success","Disabled");
        }catch (Exception e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("fail","Fail to enabled");
        }
        return "redirect:/list-class";
    }


    //get information of class
    @GetMapping("update-class/{id}")
    public String getInformtionFormUpdate(@PathVariable("id") Long id,Model model){
        List<Trainer> trainerList=trainerService.getAll();
        ClassDTO clazzDTO=classService.getClassById(id);
        model.addAttribute("clazz",clazzDTO);
        model.addAttribute("listTrainer",trainerList);

          return "management/classmanagement/classedit";
    }


    @PostMapping("/update-class/{id}")
    public String processUpdate(@PathVariable("id") Long id,@ModelAttribute("clazz") ClassDTO classDTO,RedirectAttributes redirectAttributes){
           try{
               classService.update(classDTO);
               redirectAttributes.addFlashAttribute("success","Update Successfully");
           }catch (Exception e){
               e.printStackTrace();
               redirectAttributes.addFlashAttribute("fail","Fail");
           }
        return "redirect:/list-class";
    }








}
