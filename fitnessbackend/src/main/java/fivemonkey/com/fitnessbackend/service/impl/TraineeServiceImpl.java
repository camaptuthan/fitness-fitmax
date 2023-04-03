package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.TraineeDTO;
import fivemonkey.com.fitnessbackend.dto.TrainerDTO;
import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.*;
import fivemonkey.com.fitnessbackend.repository.*;
import fivemonkey.com.fitnessbackend.service.service.TraineeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService {
    @Autowired
    private TraineeRepository traineeRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
   RegistrationRepository registrationRepository;


    @Autowired
    ServicesRepository servicesRepository;
    @Autowired
    ModelMapperConfiguration<Trainee, TraineeDTO> modelMapperConfiguration;

    @Override
    public List<TraineeDTO> getTraineeSw(String cityName) {
        return modelMapperConfiguration.mapList(traineeRepository.getTraineeSw(cityName), TraineeDTO.class);
    }

    @Override
    public void changeStatusChangeSt(String email,String cityName ,String studioId, String serviceId, String serviceOld) {
        Trainee trainee = traineeRepository.getTraineeByEmail(email);
        trainee.setStatusSw(1);
        trainee.setCitySwitch(cityName);
        trainee.setStudioSwitch(studioId);
        trainee.setServiceSwitch(serviceId);


        History history = new History();
        history.setTrainee(trainee);
        history.setNewCity(trainee.getCitySwitch());
        history.setNewPackage(serviceId);
        history.setNewStudio(studioId);
        history.setStatus(trainee.getStatusSw());

        User user = userRepository.getUserByEmail(email);
        Services servicesNew = servicesRepository.getServicesById(serviceId);
        Services servicesOld = servicesRepository.getServicesByRegistrationsId(serviceOld);
        history.setOldCity(user.getCity().getName());
        history.setOldPackage(serviceOld);
        history.setOldPrice(servicesOld.getPrice());
        history.setNewPrice(servicesNew.getPrice());

        history.setDate(new Date());
        historyRepository.save(history);
        traineeRepository.save(trainee);
    }

    @Override
    public TraineeDTO getTraineeByEmail(String email) {
        return modelMapperConfiguration.map(traineeRepository.getTraineeByEmail(email), TraineeDTO.class);
    }

    @Override
    public void accpectSwichSt(TraineeDTO traineeDTO) {
        Trainee trainee = traineeRepository.getTraineeByEmail(traineeDTO.getEmail());
        trainee.setStatusSw(2);

        City city = cityRepository.getCityByName(traineeDTO.getCitySwitch());
        city.setName(traineeDTO.getCitySwitch());
        trainee.getUser().setCity(city);
        History history = historyRepository.getHistoriesById(trainee.getCitySwitch(),trainee.getServiceSwitch());
        history.setStatus(2);
        historyRepository.save(history);

        traineeRepository.save(trainee);
    }

    @Override
    public void rerejectSwichSt(TraineeDTO traineeDTO) {
        Trainee trainee = traineeRepository.getTraineeByEmail(traineeDTO.getEmail());
        trainee.setStatusSw(0);
        trainee.setCitySwitch("");
        trainee.setStudioSwitch("");

        History history = historyRepository.getHistoriesById(trainee.getCitySwitch(),trainee.getServiceSwitch());
        history.setStatus(0);
        historyRepository.save(history);

        traineeRepository.save(trainee);
    }

    @Override
    public List<TraineeDTO> getTraineeSwByAdmin() {
        return modelMapperConfiguration.mapList(traineeRepository.getTraineeByEmailByAdmin(), TraineeDTO.class);
    }


}
