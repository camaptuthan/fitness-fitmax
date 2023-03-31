package fivemonkey.com.fitnessbackend.controller;
import fivemonkey.com.fitnessbackend.dto.ScheduleDTO;
import fivemonkey.com.fitnessbackend.dto.SessionDTO;
import fivemonkey.com.fitnessbackend.service.ScheduleService;
import fivemonkey.com.fitnessbackend.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private SessionService sessionService;

    @GetMapping("")
    public List<ScheduleDTO> getSchedules(@RequestParam(value = "start", required = false) String start,
                                          @RequestParam(value ="end", required = false) String end) throws ParseException {
        return scheduleService.getAll(formatTime(start), formatTime(end));
    }


    @GetMapping("/session/{schedule_id}")
    public List<SessionDTO> getSessionByScheduleId(@PathVariable("schedule_id") String scheduleId,
                                                   @RequestParam(value = "start",required = false) String start,
                                                   @RequestParam(value = "end",required = false) String end
    ) throws ParseException {
        return sessionService.getRegisteredSessionByScheduleIdBetweenTimes(scheduleId, formatTime(start), formatTime(end));
    }

    @GetMapping("/session/{schedule_id}/{class_id}")
    public List<SessionDTO> getSessionByScheduleIdAndClassId(@PathVariable("schedule_id") String scheduleId,
                                                             @PathVariable("class_id") String classId,
                                                             @RequestParam(value = "start",required = false) String start,
                                                             @RequestParam(value = "end",required = false) String end
    ) throws ParseException {
        return sessionService.getSessionByScheduleIdAndClassIdBetweenTimes(scheduleId, classId, formatTime(start), formatTime(end));
    }
     
    private Date formatTime(String time) throws ParseException {
        return time != null ? new SimpleDateFormat("dd/MM/yyyy").parse(time) : new Date();
    }

}
