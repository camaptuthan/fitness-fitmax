package fivemonkey.com.fitnessbackend.service;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.entities.City;
import fivemonkey.com.fitnessbackend.repository.CityRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ModelMapperConfiguration<City, CityDTO> modelMapper;

    @Autowired
    private SessionFactory sessionFactory;

        
    public List<CityDTO> getAllCities() {
        return modelMapper.mapList(cityRepository.findAll(), CityDTO.class);
    }

        
    public CityDTO getCityById(Long id) {
        return modelMapper.map(cityRepository.getCityById(id), CityDTO.class);
    }

    public City getCityByCityId(Long id) {
        return cityRepository.getCityById(id);
    }


    public City getCityByName(String name) {
        return cityRepository.getCityByName(name);
    }

        
    public CityDTO getCityByAssistant(String email) {
        return modelMapper.map(cityRepository.getCityByStudioManager(email), CityDTO.class);
    }

        
    public CityDTO getCityByStudioManager(String email) {
        return modelMapper.map(cityRepository.getCityByStudioManager(email), CityDTO.class);
    }

        
    public CityDTO getCityByUser(String email) {
        return modelMapper.map(cityRepository.getCityByUser(email), CityDTO.class);
    }
        
    public List<CityDTO> getCities() {
        return modelMapper.mapList(cityRepository.findAll(), CityDTO.class);
    }

    public List<CityDTO> getStudiosCity() {
        return modelMapper.mapList(cityRepository.getStudiosCity(), CityDTO.class);
    }

        
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

        
    public City createCity(City city) {
        return cityRepository.save(city);
    }

        
    public List<City> getNewCity() {
        return cityRepository.getNewCity();
    }

    //Get existing city by studio
    public List<City> getStudioCity() {
        return cityRepository.getStudioCity();
    }

    //Get existing city by registration
    public List<City> getRegistrationCity() {
        return cityRepository.getRegistrationCity();
    }

    public List<CityDTO> getAllCityByKeyword(String keyword, int page) {
        int pageSize = 5;
        Session session = sessionFactory.openSession();
        String sql = "select c from City c where c.id is not null ";
        if (!"".equals(keyword)) {
            sql += " and c.name like '%" + keyword + "%' ";
        }
        Query<City> query1 = session.createQuery(sql, City.class);
        query1.setFirstResult(page * pageSize);
        query1.setMaxResults(pageSize);
        return modelMapper.mapList(query1.getResultList(), CityDTO.class);
    }

    public int getTotalPageCity(String keyword) {
        int pageSize = 5;
        Session session = sessionFactory.openSession();
        String sql = "select count(c.id) from City c where c.id is not null ";
        if (!"".equals(keyword)) {
            sql += " and c.name like '%" + keyword + "%' ";
        }
        Query queryCount = session.createQuery(sql);
        Long countResult = (Long) queryCount.uniqueResult();
        if ((int) (countResult % pageSize) != 0) {
            return (int) (countResult / pageSize) + 1;
        } else {
            return (int) (countResult / pageSize);
        }
    }
}
