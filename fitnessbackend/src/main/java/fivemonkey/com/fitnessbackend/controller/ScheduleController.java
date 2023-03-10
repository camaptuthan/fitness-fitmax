package fivemonkey.com.fitnessbackend.controller;


import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.ScheduleDTO;
import fivemonkey.com.fitnessbackend.dto.SessionDTO;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.services.ClassService;
import fivemonkey.com.fitnessbackend.services.ScheduleService;
import fivemonkey.com.fitnessbackend.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ClassService classService;

    @Autowired
    private SessionService sessionService;

    @GetMapping("")
    public List<ScheduleDTO> getSchedules(@RequestParam("start") String start,
                                          @RequestParam("end") String end) {
        return scheduleService.getAll(formatTime(start), formatTime(end));
    }


    @GetMapping("/session/{schedule_id}")
    public List<SessionDTO> getSessionByScheduleId(@PathVariable("schedule_id") String scheduleId,
                                                   @RequestParam("start") String start,
                                                   @RequestParam("end") String end
    ) {
        return sessionService.getSessionByScheduleIdBetweenTimes(scheduleId, formatTime(start), formatTime(end));
    }

     
    private Date formatTime(String time) {
        Date output = null;
        // SimpleDateFormat class Object
        SimpleDateFormat dtobj = new SimpleDateFormat("dd/MM/yyyy");
        // Dates
        // Parsing dates in Date datatype
        try {
            output = dtobj.parse(time);
        } catch (ParseException pe) {
            System.out.println(pe.getMessage());
        }

        return output;

    }

    @GetMapping("/registered-class")
    public List<ClassDTO> getClasses(@AuthenticationPrincipal UserDetail userDetail) {
        return classService.getRegistrationClassByUserEmail(userDetail.getUser().getEmail());
    }


//
//    @GetMapping("/list-class")
//    public List<Clazz> getClasses() {
//        return classService.findAll();
//    }

}
