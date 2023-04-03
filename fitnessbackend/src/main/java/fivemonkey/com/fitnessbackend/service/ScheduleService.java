package fivemonkey.com.fitnessbackend.service;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.ScheduleDTO;
import fivemonkey.com.fitnessbackend.entities.Schedule;
import fivemonkey.com.fitnessbackend.repository.ClassRepository;
import fivemonkey.com.fitnessbackend.repository.RegistrationRepository;
import fivemonkey.com.fitnessbackend.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private SessionService sessionService;
    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private ModelMapperConfiguration<Schedule, ScheduleDTO> modelMapperConfiguration;

    public List<ScheduleDTO> getAll(Date startTime, Date endTime) {
        List<ScheduleDTO> scheduleDTOS = new ArrayList<>();
        scheduleRepository.findAll().forEach(schedule -> {
            ScheduleDTO scheduleDTO = modelMapperConfiguration.map(schedule, ScheduleDTO.class);
            scheduleDTO.setStartTime(getTime(schedule.getStartTime()));
            scheduleDTO.setEndTime(getTime(schedule.getEndTime()));
            scheduleDTO.setHaveSessions(!sessionService.getRegisteredSessionByScheduleIdBetweenTimes(schedule.getId(), startTime, endTime).isEmpty());
            scheduleDTOS.add(scheduleDTO);
        });
        return scheduleDTOS;
    }

    //getting time from specify date
    private String getTime(Date date) {
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        return localDateFormat.format(date);
    }

}
