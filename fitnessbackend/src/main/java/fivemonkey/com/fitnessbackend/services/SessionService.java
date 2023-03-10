package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.SessionDTO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface SessionService {
    List<SessionDTO> getSessionByScheduleIdBetweenTimes(String scheduleId, Date startTime, Date endTime);
}
