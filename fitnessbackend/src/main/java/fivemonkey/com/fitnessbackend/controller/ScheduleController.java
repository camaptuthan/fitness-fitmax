package fivemonkey.com.fitnessbackend.controller;


import fivemonkey.com.fitnessbackend.api.response.ApiResponse;
import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.ScheduleDTO;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.services.ClassService;
import fivemonkey.com.fitnessbackend.services.ScheduleService;
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

    @GetMapping("")
    public List<ScheduleDTO> getSchedules() {
        return scheduleService.getAll();
    }

    @GetMapping("/{service_id}/{year}")
    public ApiResponse<ClassDTO> getScheduleByClassInformation(@AuthenticationPrincipal UserDetail userDetail,
                                                               @PathVariable("service_id") String serviceId,
                                                               @PathVariable("year") String year,
                                                               @RequestParam("start") String start,
                                                               @RequestParam String end) {
        ApiResponse<ClassDTO> response = new ApiResponse<>();
        UserDetail user = (UserDetail) userDetail;
        response.setData(scheduleService.getByInfor(userDetail.getUser().getEmail(), serviceId, formatTime(year, start), formatTime(year, end)));
        return response;
    }

    private Date formatTime(String year, String date) {
        Date output = null;
        // SimpleDateFormat class Object
        SimpleDateFormat dtobj = new SimpleDateFormat("dd/MM/yyyy");
        // Dates
        // Parsing dates in Date datatype
        try {
            output = dtobj.parse(date + "/" + year);
        } catch (ParseException pe) {
            System.out.println(pe.getMessage());
        }

        return output;

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
