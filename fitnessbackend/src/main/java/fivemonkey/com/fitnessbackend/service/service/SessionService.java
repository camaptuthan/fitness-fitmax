package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.SessionDTO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface SessionService {

    //get all sessions by schedule id between start time and end time
    List<SessionDTO> getRegisteredSessionByScheduleIdBetweenTimes(String scheduleId, Date startTime, Date endTime);


    //get all sessions by schedule id and class id between start time and end time
    List<SessionDTO> getSessionByScheduleIdAndClassIdBetweenTimes(String scheduleId, String classId, Date formatTime, Date formatTime1);
}
