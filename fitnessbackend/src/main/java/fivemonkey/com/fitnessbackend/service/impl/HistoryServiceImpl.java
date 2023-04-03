package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.HistoryDTO;
import fivemonkey.com.fitnessbackend.dto.StudioDTO;
import fivemonkey.com.fitnessbackend.dto.TrainerDTO;
import fivemonkey.com.fitnessbackend.entities.History;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.repository.HistoryRepository;
import fivemonkey.com.fitnessbackend.service.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private ModelMapperConfiguration<History, HistoryDTO> modelMapperHistory;
    @Autowired
    private HistoryRepository historyRepository;
    @Override
    public HistoryDTO getHistoryById(String cityName, String packageId) {
        return modelMapperHistory.map(historyRepository.getHistoriesById(cityName,packageId), HistoryDTO.class);
    }
}
