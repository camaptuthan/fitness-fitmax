package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.DistrictDTO;
import fivemonkey.com.fitnessbackend.entities.District;
import fivemonkey.com.fitnessbackend.repository.DistrictRepository;
import fivemonkey.com.fitnessbackend.service.service.DistrictService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ModelMapperConfiguration<District, DistrictDTO> modelMapper;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<DistrictDTO> getDistrictByCityId(Long id) {
        return modelMapper.mapList(districtRepository.getDistrictsByCity(id), DistrictDTO.class);
    }

    @Override
    public District getDistrictByDistrictId(String id) {
        return districtRepository.getDistrictByDistrictId(Long.valueOf(id));
    }

    @Override
    public District getDistrictByName(String name) {
        return districtRepository.getDistrictsByName(name);
    }

    @Override
    public District createDistrict(District district) {
        return districtRepository.save(district);
    }

    @Override
    public District saveDistrict(District district) {
        return districtRepository.save(district);
    }

    @Override
    public District getDistrictByCityAndDistrict(String city, String district) {
        return districtRepository.getDistrictsByCityAndDistrict(city, district);
    }

    @Override
    public List<District> getNewDistrict(String city) {
        return districtRepository.getDistrictsByCity(Long.valueOf(city));
    }

    @Override
    public List<DistrictDTO> getDistrictByCity(Long cityid, String keyword, int pageNumber) {
        int pageSize = 5;
        Session session = sessionFactory.openSession();
        String sql = "select d from District d where d.id is not null ";
        if (cityid != 0L) {
            sql += " and d.city.id = " + cityid + " ";
        }
        if (!"".equals(keyword)) {
            sql += " and d.name like '%" + keyword + "%' ";
        }
        Query<District> query = session.createQuery(sql, District.class);
        query.setFirstResult(pageNumber * pageSize);
        query.setMaxResults(pageSize);
        return modelMapper.mapList(query.getResultList(), DistrictDTO.class);
    }

    @Override
    public int totalPageDistrictByCity(Long cityid, String keyword) {
        int pageSize = 5;
        Session session = sessionFactory.openSession();
        String sql = "select count(d.id) from District d where d.id is not null ";
        if (cityid != 0L) {
            sql += " and d.city.id = " + cityid + " ";
        }
        if (!"".equals(keyword)) {
            sql += " and d.name like '%" + keyword + "%' ";
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
