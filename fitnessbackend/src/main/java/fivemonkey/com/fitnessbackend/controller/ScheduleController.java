package fivemonkey.com.fitnessbackend.controller;


import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.ScheduleDTO;
import fivemonkey.com.fitnessbackend.services.ClassService;
import fivemonkey.com.fitnessbackend.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{user_email}/{service_id}/{year}")
    public ClassDTO getScheduleByClassInformation(@PathVariable("user_email") String email, @PathVariable("service_id") String serviceId, @PathVariable("year") String year, @RequestParam("start") String start, @RequestParam String end) {
        return scheduleService.getByInfor(email, serviceId, year, start, end);
    }


    @GetMapping("list-class")
    public List<ClassDTO> getClasses() {
        return classService.findAll();
    }



//
//    @GetMapping("/list-class")
//    public List<Clazz> getClasses() {
//        return classService.findAll();
//    }

}
