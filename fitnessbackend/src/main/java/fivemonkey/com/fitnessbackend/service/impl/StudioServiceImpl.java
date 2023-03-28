package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.StudioDTO;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.repository.StudioRepository;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import fivemonkey.com.fitnessbackend.service.service.StudioService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudioServiceImpl implements StudioService {

    @Autowired
    private StudioRepository studioRepository;
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapperConfiguration<Studio, StudioDTO> modelMapper;

//    @Override
//    public List<StudioDTO> getAllStudios() {
//        List<StudioDTO> studioDTOS = new ArrayList<>();
//        studioRepository.findAll().forEach(studio -> {
//            StudioDTO studioDTO = modelMapper.map(studio, StudioDTO.class);
//            String managerEmail = userRepository.listManagerByStudio(studio.getId());
//            studioDTO.setManagerEmail(managerEmail);
//            studioDTOS.add(studioDTO);
//        });
//        return studioDTOS;
//    }

    //remove
    @Override
    public List<StudioDTO> getAllStudios() {
        List<StudioDTO> studioDTOS = new ArrayList<>();
        studioRepository.findAll().forEach(studio -> {
            StudioDTO studioDTO = modelMapper.map(studio, StudioDTO.class);
            String managerEmail = userRepository.listManagerByStudio(studio.getId());
            studioDTO.setManagerEmail(managerEmail);
            studioDTOS.add(studioDTO);
        });
        return studioDTOS;
    }

    //remove

    @Override
    public StudioDTO getStudioByStudioManager(String email) {

        return modelMapper.map(studioRepository.findStudioByStudioManager(email), StudioDTO.class);
    }

    @Override
    public StudioDTO getStudioDTOById(String id) {
        return modelMapper.map(studioRepository.findStudioById(id), StudioDTO.class);
    }


    @Override
    public List<StudioDTO> getAllStudio() {
        return modelMapper.mapList(studioRepository.findAll(), StudioDTO.class);
    }



//    @Override
//    public void updateStudio(Studio studioDTO) {
//        StudioDTO studio = modelMapper.map(studioDTO, StudioDTO.class);
//        studioRepository.save(studioDTO);
//    }

    @Override
    public Studio getStudioById(String id) {
        return studioRepository.findStudioById(id);
    }

    @Override
    public Studio getStudioByStudioId(String id) {
        return studioRepository.findStudioById(id);
    }

    @Override
    public Studio getStudioByManagerId(String id) {
        return studioRepository.getStudioById(id);
    }

    @Override
    public List<StudioDTO> getAllStudiosByCity(String cityname) {
        return modelMapper.mapList(studioRepository.getStudioByCity(cityname), StudioDTO.class);
    }

    @Override
    public List<StudioDTO> getStudioByCity(String cityname, int page) {
        int pageSize = 4;
        Session session = sessionFactory.openSession();
        String sql = "select s from Studio s where s.id is not null ";
        if(!"All".equals(cityname)){
            sql += " and s.district.city.name = '" + cityname + "' ";
        }
        Query<Studio> query = session.createQuery(sql, Studio.class);
        query.setFirstResult(page * pageSize);
        query.setMaxResults(pageSize);
        return modelMapper.mapList(query.getResultList(), StudioDTO.class);
    }

    @Override
    public int getTotalPage(String cityname) {
        int pageSize = 4;
        Session session = sessionFactory.openSession();
        String sql = "select count(s.id) from Studio s where s.id is not null ";
        if(!"All".equals(cityname)){
            sql += " and s.district.city.name = '" + cityname + "' ";
        }
        Query queryCount = session.createQuery(sql);
        Long countResult = (Long) queryCount.uniqueResult();
        if ((int) (countResult % pageSize) != 0) {
            return (int) (countResult / pageSize) + 1;
        } else {
            return (int) (countResult / pageSize);
        }
    }

    @Override
    public List<StudioDTO> getAllStudiosByFilter(@Param("keyword") String keyword,
                                                 @Param("city") String city,
                                                 @Param("status") String studioStatus,
                                                 int pageNumber) {
        int pageSize = 5;
        Session session = sessionFactory.openSession();
        String hql = "select s from Studio s join District d on s.district.id = d.id where 1=1 ";
        if (!"".equals(keyword)) {
            keyword = keyword.trim().replaceAll("\\s+", " ");
            hql += " and concat(s.name,s.contact, s.date) like '%" + keyword + "%' ";
        }
        if (!"".equals(city)) {
            hql += " and s.district.id in (select d.id from District d where d.city.id = '" + city + "') ";
        }
        if (!"".equals(studioStatus)) {
            hql += " and s.status = '" + studioStatus + "' ";
        }

        Query<Studio> query = session.createQuery(hql, Studio.class);
        query.setFirstResult(pageNumber * pageSize);
        query.setMaxResults(pageSize);
        return modelMapper.mapList(query.getResultList(), StudioDTO.class);

    }

    @Override
    public int getTotalAllStudiosByFilter(@Param("keyword") String keyword,
                                          @Param("city") String city,
                                          @Param("status") String studioStatus) {
        int pageSize = 5;
        Session session = sessionFactory.openSession();
        String sqlcount = "select count(s.id) from Studio s join District d on s.district.id = d.id where 1=1 ";
        if (!"".equals(keyword)) {
            keyword = keyword.trim().replaceAll("\\s+", " ");
            sqlcount += " and concat(s.name,s.contact, s.date) like '%" + keyword + "%' ";
        }
        if (!"".equals(city)) {
            sqlcount += " and s.district.id in (select d.id from District d where d.city.id = '" + city + "') ";
        }
        if (!"".equals(studioStatus)) {
            sqlcount += " and s.status = '" + studioStatus + "' ";
        }

        Query queryCount = session.createQuery(sqlcount);
        Long countResult = (Long) queryCount.uniqueResult();
        if ((int) (countResult % pageSize) != 0) {
            return (int) (countResult / pageSize) + 1;
        } else {
            return (int) (countResult / pageSize);
        }
    }
    @Override
    public StudioDTO getStudioDTOByStudioId(String id) {
        StudioDTO studioDTO = modelMapper.map(studioRepository.getStudioById(id), StudioDTO.class);
        String managerEmail = userRepository.listManagerByStudio(studioDTO.getId());
        studioDTO.setManagerEmail(managerEmail);
        return studioDTO;
    }

    @Override
    public Studio saveStudio(Studio studio) {
        return studioRepository.save(studio);
    }

    @Override
    public List<StudioDTO> getAllByCity(String cityname) {
        return modelMapper.mapList(studioRepository.findStudioByCityName(cityname), StudioDTO.class);
    }

    @Override
    public Long countStudio() {
        return studioRepository.countStudio();
    }



}
