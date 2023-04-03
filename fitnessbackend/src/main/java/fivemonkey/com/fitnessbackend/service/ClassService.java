package fivemonkey.com.fitnessbackend.service;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entities.*;
import fivemonkey.com.fitnessbackend.repository.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassService {

    private int totalPage = -1;
    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;
    @Autowired
    private StudioRepository studioRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapperConfiguration<Clazz, ClassDTO> modelMapper;

    @Autowired
    private SessionFactory sessionFactory;

       
    public ClassDTO getByServiceId(String serviceId) {
        return modelMapper.map(classRepository.getClazzByServices(serviceId), ClassDTO.class);
    }

       
    public List<ClassDTO> getAll() {
        return modelMapper.mapList(classRepository.findAll(), ClassDTO.class);
    }

     
    public List<ClassDTO> getAllRelatedClass(String serviceId) {
        Clazz clazz = classRepository.getClazzByServices(serviceId);
        List<Clazz> classes = classRepository.getAllClass();
        classes = classes.stream().filter(clazzItem -> {
            Services currentServices = clazz.getServices();
            Services itemServices = clazzItem.getServices();
            if (currentServices.getId().equals(itemServices.getId())) return false;
            return currentServices.getStudio().getId().equals(itemServices.getStudio().getId())
                    || currentServices.getCity().getId().equals(itemServices.getCity().getId());
        }).collect(Collectors.toList());
        return modelMapper.mapList(classes, ClassDTO.class);
    }

    
    public List<ClassDTO> getByUserRole(User user, int currentPage, String[] keywords) {
        int size = 6;
        List<Clazz> classes = user.getStudio() == null ? classRepository.findAll(Sort.by(Sort.Direction.DESC, "services.date")) : classRepository.getClazzByUserEmail(user.getEmail());

        classes.sort((o1, o2) -> o2.getServices().getDate().compareTo(o1.getServices().getDate()));
        for (String word : keywords) {
            if (word.isBlank()) continue;
            classes = classes.stream().filter(clazz -> {
                Studio studio = clazz.getServices().getStudio();
                City city = clazz.getServices().getCity();
                if (studio == null || city == null) return false;
                return studio.getId().equals(word)
                        || city.getName().equals(word)
                        || String.valueOf(clazz.getServices().getStatus()).equals(word);
            }).collect(Collectors.toList());
        }


        this.totalPage = classes.isEmpty() ? 1 : classes.size() % size == 0 ? classes.size() / size : classes.size() / size + 1;

        return modelMapper.mapList(currentPage == 0 ? classes : classes.subList((currentPage - 1) * size, Math.min((++currentPage - 1) * size, classes.size())), ClassDTO.class);
    }

   
    public int getTotalPage() {
        return this.totalPage;
    }

       
    public ClassDTO save(ClassDTO classDTO, User user) {
        Clazz clazz = classRepository.findByServicesId(classDTO.getServicesId()).orElse(new Clazz());
        Services services = clazz.getServices() == null ? new Services(new Date()) : clazz.getServices();
        services.setCity(cityRepository.getCityByName(classDTO.getServicesCityName()));
        services.setStudio(studioRepository.getStudioById(classDTO.getServicesStudioId()));
        services.setPrice(classDTO.getServicesPrice());
        services.setName(classDTO.getServicesName());
        services.setDes(classDTO.getServicesDes());
        services.setUpdatedDate(new Date());
        services.setStatus(services.getId() != null ? classDTO.getServicesStatus() : 2);
        if (services.getId() == null) {
            services.setCategory(categoryRepository.getById(3L));
            services.setServiceType(serviceTypeRepository.getServiceTypeById(3L));
            services.setDuration(10);
            services.setUser(userRepository.getUserByEmail(user.getEmail()));
            servicesRepository.save(services);
            clazz.setServices(services);
        }
        return modelMapper.map(classRepository.save(clazz), ClassDTO.class);
    }

       
    public ClassDTO saveThumbnail(String thumbNail, String serviceId) {
        if (thumbNail.isBlank()) return null;
        Clazz clazz = classRepository.findByServicesId(serviceId).orElse(new Clazz());
        clazz.getServices().setImage(thumbNail);
        return modelMapper.map(classRepository.save(clazz), ClassDTO.class);
    }

    public ClassDTO getClassById(String id) {
        return modelMapper.map(classRepository.getClassById(id), ClassDTO.class);
    }

       
    public List<ClassDTO> getAllClass() {
        return modelMapper.mapList(classRepository.getAllClass(), ClassDTO.class);
    }

       
    public List<ClassDTO> getClassesBy4Fields(String keyword, String cityname, String studio, Long category, int pageNumber) {
        int pageSize = 5;
        Session session = sessionFactory.openSession();
        String query = "select c from Clazz c where c.services.serviceType.id = 3 and c.services.status = 2 ";
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
