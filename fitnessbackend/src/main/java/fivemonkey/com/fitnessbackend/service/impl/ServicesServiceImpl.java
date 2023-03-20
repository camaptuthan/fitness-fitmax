package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.ServicesDTO;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.repository.ServiceRepository;
import fivemonkey.com.fitnessbackend.service.service.ServicesService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService {

    @Autowired
    private ModelMapperConfiguration<Services, ServicesDTO> modelMapper;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public List<ServicesDTO> getAllServices() {
        return modelMapper.mapList(serviceRepository.findAll(), ServicesDTO.class);
    }

    @Override
    public List<ServicesDTO> getAllPackages() {
        return modelMapper.mapList(serviceRepository.getServicesByPackage(), ServicesDTO.class);
    }

    @Override
    public List<ServicesDTO> getAllClasses() {
        return modelMapper.mapList(serviceRepository.getServicesByClass(), ServicesDTO.class);
    }

    @Override
    public List<ServicesDTO> getAllPTs() {
        return modelMapper.mapList(serviceRepository.getServicesByPT(), ServicesDTO.class);
    }

    @Override
    public List<Services> getPackagesBy3Fields(@Param("keyword") String keyword,
                                               @Param("cityname") String cityname,
                                               @Param("category") Long category) {
        Session session = sessionFactory.openSession();
        String query = "select s from Services s where s.serviceType.id = 1 ";
        if (keyword != null) {
            query += " and concat(s.name,'',s.price,'',s.duration,'',s.des,'',s.date) like '%" + keyword + "%' ";
        }
        if (!"All".equals(cityname)) {
            query += " and s.services.city.name = '" + cityname + "' ";
        }
        if (!"All".equals(category)) {
            query += " and s.services.category.id = " + category + " ";
        }
        System.out.println(query);
        Query<Services> query1 = session.createQuery(query, Services.class);
        return query1.getResultList();
    }

    @Override
    public List<Services> getPackagesBy4Fields(@Param("keyword") String keyword,
                                               @Param("city") String cityname,
                                               @Param("studio") String studio,
                                               @Param("category") Long category) {
        Session session = sessionFactory.openSession();
        String sql = "select s from Services s where s.serviceType.id = 1 ";
        if (keyword != null) {
            sql += " and concat(s.name,'',s.price,'',s.duration,'',s.des,'',s.date) like %'" + keyword + "'% ";
        }
        if (!"All".equals(cityname)) {
            sql += " and s.city.name = '" + cityname + "' ";
        }
        if (!"All".equals(studio)) {
            sql += " and s.studio.id = '" + studio + "' ";
        }
        if (!"All".equals(category)) {
            sql += " and s.category.id = " + category + " ";
        }
        Query<Services> query = session.createQuery(sql, Services.class);
        return query.getResultList();
    }

    @Override
    public List<Services> getClassesByFields(String keyword, String cityname, String studio, String category) {
        return null;
    }

    @Override
    public List<Services> getPTsByFields(String keyword, String cityname, String studio, String category) {
        return null;
    }

    @Override
    public ServicesDTO getServiceById(String id) {
        return null;
    }

    @Override
    public Services save(ServicesDTO s) {
        Services services = new Services();
        services.setId(s.getId());
        services.setName(s.getName());
        services.setImage(s.getImage());
        services.setDes(s.getDes());
        services.setPrice(s.getPrice());
        services.setDate(s.getDate());
        services.setStatus(s.getStatus());
        return serviceRepository.save(services);
    }

    @Override
    public Services update(Services s) {
        Services services = serviceRepository.getById(s.getId());
        services.setId(s.getId());
        services.setName(s.getName());
        services.setImage(s.getImage());
        services.setDes(s.getDes());
        services.setPrice(s.getPrice());
        services.setDate(s.getDate());
        services.setStatus(s.getStatus());
        return serviceRepository.save(services);
    }

    //status 2 <=> disable
    @Override
    public void disableService(String id) {
        Services services = serviceRepository.getById(id);
        services.setStatus(2);
        serviceRepository.save(services);
    }

    //status 1 <=> enable
    @Override
    public void enableService(String id) {
        Services services = serviceRepository.getById(id);
        services.setStatus(1);
        serviceRepository.save(services);
    }

}
