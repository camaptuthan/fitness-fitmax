package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.ScheduleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {
    List<ScheduleDTO> getAll();
    ClassDTO getByInfor(String userEmail, String serviceId, String year, String start, String end);

}
