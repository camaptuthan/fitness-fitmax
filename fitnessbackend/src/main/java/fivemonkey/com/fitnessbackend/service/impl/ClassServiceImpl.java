package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.repository.ClassRepository;
import fivemonkey.com.fitnessbackend.service.service.ClassService;
import fivemonkey.com.fitnessbackend.service.service.RegistrationService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassRepository classRepository;
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
    public ClassDTO getClassById(String id) {
        return modelMapper.map(classRepository.getClassById(id), ClassDTO.class);
    }

    @Override
    public List<ClassDTO> getAllClass() {
        return modelMapper.mapList(classRepository.getAllClass(),ClassDTO.class);
    }

    @Override
    public List<ClassDTO> getClassesBy4Fields(@Param("keyword") String keyword,
                                              @Param("cityname") String cityname,
                                              @Param("studio") String studio,
                                              @Param("category") Long category) {
        Session session = sessionFactory.openSession();
        String query = "select c from Clazz c where c.services.serviceType.id = 3 and c.services.status = 1 ";
        if (!"".equals(keyword)) {
            query += " concat(c.services.name,'',c.services.price,'',c.services.duration,'',c.services.des,'',c.services.date) like '%" + keyword + "%' ";
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
        return modelMapper.mapList(query1.getResultList(), ClassDTO.class);
    }
}
