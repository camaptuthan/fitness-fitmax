package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.HistoryDTO;
import fivemonkey.com.fitnessbackend.entities.History;
import org.springframework.stereotype.Service;

@Service
public interface HistoryService {
HistoryDTO getHistoryById (String cityName, String packageId);
}
