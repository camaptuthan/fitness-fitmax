package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.repository.CityRepository;
import fivemonkey.com.fitnessbackend.repository.ClassRepository;
import fivemonkey.com.fitnessbackend.repository.StudioRepository;
import fivemonkey.com.fitnessbackend.service.service.ClassService;
import fivemonkey.com.fitnessbackend.service.service.RegistrationService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StudioRepository studioRepository;
    @Autowired
    private ModelMapperConfiguration<Clazz, ClassDTO> modelMapper;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ClassDTO getByServiceId(String serviceId) {
        return modelMapper.map(classRepository.getClazzByServices(serviceId), ClassDTO.class);
    }

    @Override
    public List<ClassDTO> getAll() {
        return modelMapper.mapList(classRepository.findAll(), ClassDTO.class);
    }

    @Override
    public List<ClassDTO> getByUserRole(User user) {
        List<Clazz> clazzes = user.getStudio() == null ? classRepository.findAll() : classRepository.getClazzByUserEmail(user.getEmail());
        assert clazzes != null;
        return modelMapper.mapList(clazzes, ClassDTO.class);
    }

    @Override
    public ClassDTO save(ClassDTO classDTO, User user) {
        Clazz clazz = classRepository.findByServicesId(classDTO.getServicesId()).orElse(new Clazz());
        Services services = clazz.getServices();
        services.setCity(cityRepository.getCityById(classDTO.getServicesCityId()));
        services.setStudio(studioRepository.getStudioById(classDTO.getServicesStudioId()));
        services.setName(classDTO.getServicesName());
        services.setDes(classDTO.getServicesDes());
        services.setStatus(classDTO.getServicesStatus());
        return modelMapper.map(classRepository.save(clazz), ClassDTO.class);
    }

    @Override
    public ClassDTO saveThumbnail(String thumbNail, String serviceId) {
        if (thumbNail.isBlank()) return null;
        Clazz clazz = classRepository.findByServicesId(serviceId).orElse(new Clazz());
        clazz.getServices().setImage(thumbNail);
        return modelMapper.map(classRepository.save(clazz), ClassDTO.class);
    }
    public ClassDTO getClassById(String id) {
        return modelMapper.map(classRepository.getClassById(id), ClassDTO.class);
    }

    @Override
    public List<ClassDTO> getAllClass() {
        return modelMapper.mapList(classRepository.getAllClass(), ClassDTO.class);
    }

    @Override
    public List<ClassDTO> getClassesBy4Fields(String keyword, String cityname, String studio, Long category, int pageNumber) {
        int pageSize = 5;
        Session session = sessionFactory.openSession();
        String query = "select c from Clazz c where c.services.serviceType.id = 3 and c.services.status = 1 ";
        if (!"".equals(keyword)) {
            query += " and concat(c.services.name,'',c.services.price,'',c.services.duration,'',c.services.des,'',c.services.date) like '%" + keyword + "%' ";
        }
        if (!"All".equals(cityname)) {
            query += " and c.services.city.name = '" + cityname + "' ";
        }
        if (!"All".equals(studio)) {
            query += " and c.services.studio.id = '" + studio + "' ";
        }
        if (category != 0L) {
            query += " and c.services.category.id = " + category + " ";
        }
        Query<Clazz> query1 = session.createQuery(query, Clazz.class);
        query1.setFirstResult(pageNumber * pageSize);
        query1.setMaxResults(pageSize);
        return modelMapper.mapList(query1.getResultList(), ClassDTO.class);
    }

    @Override
    public int totalPageBy4Fields(String keyword, String cityname, String studio, Long category) {
        int pageSize = 5;
        Session session = sessionFactory.openSession();
        String querycount = "select count(c.id) from Clazz c where c.services.serviceType.id = 3 and c.services.status = 2 ";
        if (!"".equals(keyword)) {
            querycount += " and concat(c.services.name,'',c.services.price,'',c.services.duration,'',c.services.des,'',c.services.date) like '%" + keyword + "%' ";
        }
        if (!"All".equals(cityname)) {
            querycount += " and c.services.city.name = '" + cityname + "' ";
        }
        if (!"All".equals(studio)) {
            querycount += " and c.services.studio.id = '" + studio + "' ";
        }
        if (category != 0L) {
            querycount += " and c.services.category.id = " + category + " ";
        }
        Query queryCount = session.createQuery(querycount);
        Long countResult = (Long) queryCount.uniqueResult();
        if ((int) (countResult % pageSize) != 0) {
            return (int) (countResult / pageSize) + 1;
        } else {
            return (int) (countResult / pageSize);
        }
    }
}
