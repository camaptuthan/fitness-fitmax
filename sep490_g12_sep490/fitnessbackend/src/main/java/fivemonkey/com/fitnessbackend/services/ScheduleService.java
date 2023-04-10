package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.ScheduleDTO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ScheduleService {

    List<ScheduleDTO> getAll(Date startTime, Date endTime);

}
