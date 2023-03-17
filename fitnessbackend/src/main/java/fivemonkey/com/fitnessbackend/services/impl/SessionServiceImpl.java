package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.SessionDTO;
import fivemonkey.com.fitnessbackend.entities.Session;
import fivemonkey.com.fitnessbackend.repository.SessionRepository;
import fivemonkey.com.fitnessbackend.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private ModelMapperConfiguration<Session, SessionDTO> modelMapperConfiguration;

    @Override
    public List<SessionDTO> getRegisteredSessionByScheduleIdBetweenTimes(String scheduleId, Date startTime, Date endTime) {
        return modelMapperConfiguration.mapList(sessionRepository.getSessionsByScheduleAndHappenedDateBetween(scheduleId, startTime, endTime), SessionDTO.class);
    }

    @Override
    public List<SessionDTO> getSessionByScheduleIdAndClassIdBetweenTimes(String scheduleId, String classId, Date formatTime, Date formatTime1) {
        return modelMapperConfiguration.mapList(sessionRepository.getSessionsByScheduleAndClassAndHappenedDateBetween(scheduleId, classId, formatTime, formatTime1), SessionDTO.class);
    }
}
