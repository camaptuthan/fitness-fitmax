package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.repository.ClassRepository;
import fivemonkey.com.fitnessbackend.services.ClassService;
import fivemonkey.com.fitnessbackend.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClassController {
    @Autowired
    ClassRepository classRepository;
    @Autowired
    private ClassService classService;

    @Autowired
    private ScheduleService scheduleService;
    @GetMapping("/list-class")
    public String classes(Model model) {
        List<Clazz> classDTOList = classService.findAll();
        for (Clazz c :
                classDTOList) {
            System.out.println(c.toString());

        }
        System.out.println("size is:" + classDTOList.size());
        model.addAttribute("list", classDTOList);
        model.addAttribute("size", classDTOList.size());
        return "management/classmanagement/classlist";
    }

    //add class
    @GetMapping("/add-class")
    public String addClass(Model model) {

        return "management/classmanagement/classlist";
    }


//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable Long id){
//        classRepository.deleteById(id);
//    }

    @GetMapping("/schedule")
    public String getSchedule(){

        scheduleService.getAll();
        return "management/schedulemanagement/schedule_table";
    }
}
