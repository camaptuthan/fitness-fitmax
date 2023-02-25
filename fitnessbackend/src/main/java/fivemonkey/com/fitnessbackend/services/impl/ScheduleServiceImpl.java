package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.ScheduleDTO;
import fivemonkey.com.fitnessbackend.dto.SessionDTO;
import fivemonkey.com.fitnessbackend.repository.ClassRepository;
import fivemonkey.com.fitnessbackend.repository.ScheduleRepository;
import fivemonkey.com.fitnessbackend.services.ScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ScheduleDTO> getAll() {
        List<ScheduleDTO> scheduleDTOS = new ArrayList<>();
        scheduleRepository.findAll().forEach(schedule -> {
            ScheduleDTO scheduleDTO = modelMapper.map(schedule, ScheduleDTO.class);
            scheduleDTO.setStartTime(getTime(schedule.getStartTime()));
            scheduleDTO.setEndTime(getTime(schedule.getEndTime()));
            List<SessionDTO> sessionDTOs = new ArrayList<>();
            if (schedule.getSessions().size() > 0) {
                schedule.getSessions().forEach(session -> {
                    SessionDTO sessionDTO = modelMapper.map(session, SessionDTO.class);
                    sessionDTO.setWeekDay("" + getWeekday(session.getHappenedDate()));
                    sessionDTOs.add(sessionDTO);
                });
            }
            scheduleDTO.setSessionDTOs(sessionDTOs);
            scheduleDTOS.add(scheduleDTO);
        });
        return scheduleDTOS;
    }


    //get schedule information by provided classId
    @Override
    public ClassDTO getByClassId(Long id) {

        List<ScheduleDTO> scheduleDTOS = new ArrayList<>();


        scheduleRepository.findAll().forEach(schedule -> {
            ScheduleDTO scheduleDTO = modelMapper.map(schedule, ScheduleDTO.class);
            scheduleDTO.setStartTime(getTime(schedule.getStartTime()));
            scheduleDTO.setEndTime(getTime(schedule.getEndTime()));

            List<SessionDTO> sessionDTOs = new ArrayList<>();
            if (schedule.getSessions().size() > 0) {
                schedule.getSessions().forEach(session -> {
                    if (session.getAClass().getId() == id) {
                        SessionDTO sessionDTO = modelMapper.map(session, SessionDTO.class);
                        sessionDTO.setWeekDay("" + getWeekday(session.getHappenedDate()));
                        sessionDTOs.add(sessionDTO);
                    }
                });
            }
            scheduleDTO.setSessionDTOs(sessionDTOs);
            scheduleDTOS.add(scheduleDTO);
        });

        ClassDTO classDTO = modelMapper.map(classRepository.findById(id).get(), ClassDTO.class);

        classDTO.setScheduleDTO(scheduleDTOS);
        return classDTO;
    }


    //getting weekday from specify date
    private int getWeekday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int dayOfWeekNum = cal.get(Calendar.DAY_OF_WEEK);

        DateFormat formatter = new SimpleDateFormat("EEEE");
        String dayOfWeekString = formatter.format(cal.getTime());
//        System.out.println("Day of the Week - in Number :: " + dayOfWeekNum);
//        System.out.println("Day of the Week - in Text :: " + dayOfWeekString);

        return dayOfWeekNum;
    }

    //getting time from specify date
    private String getTime(Date date) {
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        String time = localDateFormat.format(date);
        return time;
    }
}
