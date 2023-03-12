package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.PersonalTrainingDTO;
import fivemonkey.com.fitnessbackend.entities.PersonalTraining;
import fivemonkey.com.fitnessbackend.repository.PersonalTrainingRepository;
import fivemonkey.com.fitnessbackend.services.PersonalTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalTrainingServiceImpl implements PersonalTrainingService {

    @Autowired
    private PersonalTrainingRepository personalTrainingRepository;

    @Autowired
    private ModelMapperConfiguration<PersonalTraining, PersonalTrainingDTO> modelMapperConfiguration;

    @Override
    public PersonalTrainingDTO getPersonalTrainingByServiceId(String serviceId) {
        return modelMapperConfiguration.map(personalTrainingRepository.findByServicesId(serviceId), PersonalTrainingDTO.class);
    }
}
