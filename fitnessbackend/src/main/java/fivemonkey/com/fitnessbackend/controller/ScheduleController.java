package fivemonkey.com.fitnessbackend.controller;


import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.ScheduleDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.services.ClassService;
import fivemonkey.com.fitnessbackend.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ClassService classService;

    @GetMapping("")
    public List<ScheduleDTO> getSchedules() {
        return scheduleService.getAll();
    }

    @GetMapping("/{id}")
    public ClassDTO getScheduleByClassId(@PathVariable("id") String id) {
        return scheduleService.getByClassId(id);
    }

    @GetMapping("/list-class")
    public List<ClassDTO> getClasses() {
        return classService.findAll();
    }
//
//    @GetMapping("/list-class")
//    public List<Clazz> getClasses() {
//        return classService.findAll();
//    }
}
