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
import java.text.ParseException;
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
    public ClassDTO getByInfor(String email, String serviceId, String year, String start, String end) {


        List<Registration> myRegistrations = registrationRepository.getRegistrationByTrainee(new Trainee(email));

        if (myRegistrations == null || myRegistrations.size() == 0) {
            return null;
        }
        //get class information
        ClassDTO classDTO = modelMapper.map(classRepository.findById(serviceId).get(), ClassDTO.class);


        //get schedule of given class
        List<ScheduleDTO> scheduleDTOS = new ArrayList<>();
        Date startTime = formatTime(year, start);
        Date endTime = formatTime(year, end);
        scheduleRepository.findAll().forEach(schedule -> {

            ScheduleDTO scheduleDTO = modelMapper.map(schedule, ScheduleDTO.class);
            scheduleDTO.setStartTime(getTime(schedule.getStartTime()));
            scheduleDTO.setEndTime(getTime(schedule.getEndTime()));

            List<SessionDTO> sessionDTOs = new ArrayList<>();
            if (schedule.getSessions().size() > 0) {
                schedule.getSessions().forEach(session -> {
                    if (session.getAClass().getId().equals(serviceId)
                            && session.getHappenedDate().toString().contains(year)
                    ) {
                        if (session.getHappenedDate().after(startTime)
                                && session.getHappenedDate().before(endTime)
                                || session.getHappenedDate().compareTo(startTime) == 0
                                || session.getHappenedDate().compareTo(endTime) == 0
                        ) {
                            SessionDTO sessionDTO = modelMapper.map(session, SessionDTO.class);
                            sessionDTO.setHappenedDate(session.getHappenedDate().toString());
                            sessionDTO.setWeekDay("" + getWeekday(session.getHappenedDate()));
                            sessionDTOs.add(sessionDTO);
                        }
                    }
                });
            }

            scheduleDTO.setSessionDTOs(sessionDTOs);
            scheduleDTOS.add(scheduleDTO);
        });

        classDTO.setScheduleDTO(scheduleDTOS);
        return classDTO;
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
