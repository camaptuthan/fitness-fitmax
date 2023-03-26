package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.ServicesDTO;
import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.ServiceType;
import fivemonkey.com.fitnessbackend.entities.Services;

import fivemonkey.com.fitnessbackend.repository.ServiceTypeRepository;
import fivemonkey.com.fitnessbackend.repository.ServicesRepository;
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
    private ServicesRepository serviceRepository;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public void updatePackageImg(ServicesDTO servicesDTO) {
        Services services = serviceRepository.getPackageById(servicesDTO.getId());
        services.setImage(servicesDTO.getImage());
        serviceRepository.save(services);

    }

    @Override
    public List<ServicesDTO> getAllServices() {
        return modelMapper.mapList(serviceRepository.findAll(), ServicesDTO.class);
    }

    @Override
    public List<ServicesDTO> getAllPackages() {
        return modelMapper.mapList(serviceRepository.getServicesByPackage(), ServicesDTO.class);
    }

    @Override
    public ServicesDTO getPackageDTOById(String id) {
        return modelMapper.map(serviceRepository.getPackageById(id), ServicesDTO.class);
    }

    @Override
    public Services getPackageById(String id) {
        return serviceRepository.getPackageById(id);
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
    public List<ServicesDTO> getPackagesBy3Fields(@Param("keyword") String keyword,
                                                  @Param("cityname") String cityname,
                                                  @Param("category") Long category) {
        Session session = sessionFactory.openSession();
        String query = "select s from Services s where s.serviceType.id = 1 and s.status = 2 ";
        if (!"".equals(keyword)) {
            query += " and concat(s.name,'',s.price,'',s.duration,'',s.des,'',s.date) like '%" + keyword + "%' ";
        }
        if (!"All".equals(cityname)) {
            query += " and s.city.name = '" + cityname + "' ";
        }
        if (category != 0L) {
            query += " and s.category.id = " + category + " ";
        }
        Query<Services> query1 = session.createQuery(query, Services.class);
        return modelMapper.mapList(query1.getResultList(), ServicesDTO.class);
    }

    @Override
    public List<ServicesDTO> getPackagesBy4Fields(@Param("keyword") String keyword,
                                                  @Param("cityname") String cityname,
                                                  @Param("studio") String studio,
                                                  @Param("category") Long category) {
        Session session = sessionFactory.openSession();
        String sql = "select s from Services s where s.serviceType.id = 1 ";
        if (!"".equals(keyword)) {
            sql += " and concat(s.name,'',s.price,'',s.duration,'',s.des,'',s.date) like '%" + keyword + "%' ";
        }
        if (!"All".equals(cityname)) {
            sql += " and s.city.name = '" + cityname + "' ";
        }
        if (!"All".equals(studio)) {
            sql += " and s.studio.id = '" + studio + "' ";
        }
        if (category != 0L) {
            sql += " and s.category.id = " + category + " ";
        }
        Query<Services> query = session.createQuery(sql, Services.class);
        return modelMapper.mapList(query.getResultList(), ServicesDTO.class);
    }

    @Override
    public List<Services> getClassesByFields(String keyword, String cityname, String studio, Long category) {
        return null;
    }

    @Override
    public List<Services> getPTsByFields(String keyword, String cityname, String studio, Long category) {
        return null;
    }

    @Override
    public ServicesDTO getServiceById(String id) {
        return modelMapper.map(serviceRepository.getById(id), ServicesDTO.class);
    }

    @Override
    public Services addNewPackage(ServicesDTO s) {
        Services services = new Services();
        services.setId(s.getId());
        services.setName(s.getName());
        services.setImage(s.getImage());
        services.setDes(s.getDes());
        services.setPrice(s.getPrice());
        services.setDate(s.getDate());
        services.setStatus(s.getStatus());
        services.setServiceType(serviceTypeRepository.getServiceTypeById(1L));
        return serviceRepository.save(services);
    }

    @Override
    public List<ServicesDTO> getServiceOfStudio(String id,Long idC) {
        return modelMapper.mapList(serviceRepository.getServicesByStudioIdAndCateId(id,idC), ServicesDTO.class);
    }

    @Override
    public List<ServicesDTO> getAllServiceOfStudio(String id) {
        return modelMapper.mapList(serviceRepository.getServicesByStudio(id), ServicesDTO.class);
    }

}
