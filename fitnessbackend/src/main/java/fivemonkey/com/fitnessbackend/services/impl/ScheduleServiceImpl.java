package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.ScheduleDTO;
import fivemonkey.com.fitnessbackend.dto.SessionDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.repository.ClassRepository;
import fivemonkey.com.fitnessbackend.repository.ScheduleRepository;
import fivemonkey.com.fitnessbackend.services.ScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
            List<SessionDTO> sessionDTOs = new ArrayList<>();
            if (schedule.getSessions().size() > 0) {
                schedule.getSessions().forEach(session -> {
                    SessionDTO sessionDTO = modelMapper.map(session, SessionDTO.class);
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
        ClassDTO classDTO = modelMapper.map(classRepository.findById(id).get(), ClassDTO.class);
        List<ScheduleDTO> scheduleDTOS = getAll();
        classDTO.setScheduleDTO(scheduleDTOS);
        return classDTO;
    }


}
