package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.ScheduleDTO;
import fivemonkey.com.fitnessbackend.dto.SessionDTO;
import fivemonkey.com.fitnessbackend.entities.Registration;
import fivemonkey.com.fitnessbackend.entities.Trainee;
import fivemonkey.com.fitnessbackend.repository.ClassRepository;
import fivemonkey.com.fitnessbackend.repository.RegistrationRepository;
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
    private RegistrationRepository registrationRepository;

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
    public ClassDTO getByInfor(String email, String serviceId, Date startTime, Date endTime) {
        ClassDTO classDTO = null;

        List<Registration> myRegistrations  = registrationRepository.getRegistrationByTrainee(email);

        if (myRegistrations.isEmpty()) {
            return classDTO;
        }
        //get class information
        classDTO = modelMapper.map(classRepository.findById(serviceId).get(), ClassDTO.class);


        //get schedule of given class
        List<ScheduleDTO> scheduleDTOS = new ArrayList<>();
         scheduleRepository.findAll().forEach(schedule -> {

            ScheduleDTO scheduleDTO = modelMapper.map(schedule, ScheduleDTO.class);
            scheduleDTO.setStartTime(getTime(schedule.getStartTime()));
            scheduleDTO.setEndTime(getTime(schedule.getEndTime()));

            List<SessionDTO> sessionDTOs = new ArrayList<>();
            if (schedule.getSessions().size() > 0) {
                schedule.getSessions().forEach(session -> {
                    if (session.getAClass().getId().equals(serviceId)
                            && session.getHappenedDate().after(startTime)
                            && session.getHappenedDate().before(endTime)
                            || session.getHappenedDate().compareTo(startTime) == 0
                            || session.getHappenedDate().compareTo(endTime) == 0) {

                        SessionDTO sessionDTO = modelMapper.map(session, SessionDTO.class);
                        sessionDTO.setHappenedDate(session.getHappenedDate().toString());
                        sessionDTO.setWeekDay("" + getWeekday(session.getHappenedDate()));
                        sessionDTOs.add(sessionDTO);

                    }
                });
            }

            scheduleDTO.setSessionDTOs(sessionDTOs);
            scheduleDTOS.add(scheduleDTO);
        });
         classDTO.setScheduleDTO(scheduleDTOS);
        return classDTO;
    }

    //getting time from specify date
    private String getTime(Date date) {
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        return localDateFormat.format(date);
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
}
