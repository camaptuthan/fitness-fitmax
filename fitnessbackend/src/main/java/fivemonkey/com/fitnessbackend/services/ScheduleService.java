package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.ScheduleDTO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ScheduleService {
    List<ScheduleDTO> getAll();

    ClassDTO getByInfor(String userEmail, String serviceId, Date startTime, Date endTime);

    //get schedule information by provided classId
}
