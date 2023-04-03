package fivemonkey.com.fitnessbackend.service;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.HistoryDTO;
import fivemonkey.com.fitnessbackend.entities.History;
import fivemonkey.com.fitnessbackend.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService{
    @Autowired
    private ModelMapperConfiguration<History, HistoryDTO> modelMapperHistory;
    @Autowired
    private HistoryRepository historyRepository;
    
    public HistoryDTO getHistoryById(String cityName, String packageId) {
        return modelMapperHistory.map(historyRepository.getHistoriesById(cityName,packageId), HistoryDTO.class);
    }
}
