package fivemonkey.com.fitnessbackend.service;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.SessionDTO;
import fivemonkey.com.fitnessbackend.entities.Session;
import fivemonkey.com.fitnessbackend.repository.ClassRepository;
import fivemonkey.com.fitnessbackend.repository.ScheduleRepository;
import fivemonkey.com.fitnessbackend.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ModelMapperConfiguration<Session, SessionDTO> modelMapper;

           
    public List<SessionDTO> getRegisteredSessionByScheduleIdBetweenTimes(String scheduleId, Date startTime, Date endTime) {
        return modelMapper.mapList(sessionRepository.getSessionsByScheduleAndHappenedDateBetween(scheduleId, startTime, endTime), SessionDTO.class);
    }

           
    public List<SessionDTO> getSessionByScheduleIdAndClassIdBetweenTimes(String scheduleId, String serviceId, Date formatTime, Date formatTime1) {
        return modelMapper.mapList(sessionRepository.getSessionsByScheduleAndClassAndHappenedDateBetween(scheduleId, serviceId, formatTime, formatTime1), SessionDTO.class);
    }

           
    public SessionDTO save(SessionDTO sessionDTO) {
        Session session = sessionRepository.findById(sessionDTO.getId() == null ? "" : sessionDTO.getId()).orElse(new Session(new Date()));
        session.setName(sessionDTO.getName());
        if (sessionDTO.getClassId() != null) {
            session.setAClass(classRepository.getById(sessionDTO.getClassId()));
        }
        session.setSchedule(scheduleRepository.getById(sessionDTO.getScheduleId()));
        session.setDescription(sessionDTO.getDescription());
        session.setHappenedDate(sessionDTO.getHappenedDate());
        return modelMapper.map(sessionRepository.save(session), SessionDTO.class);
    }
}
