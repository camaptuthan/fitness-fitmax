package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.PackageDTO;
import fivemonkey.com.fitnessbackend.entities.Package;
import fivemonkey.com.fitnessbackend.repository.PackageRepository;
import fivemonkey.com.fitnessbackend.services.PackageService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    ModelMapperConfiguration<Package, PackageDTO> modelMapper;

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<PackageDTO> getAll() {
        List<PackageDTO> list = new ArrayList<>();
        List<Package> packages = packageRepository.findAll();
        for (Package p : packages) {
            list.add(modelMapper.map(p, PackageDTO.class));
        }
        return list;
    }

    @Override
    public List<Package> getByFields(@Param("keyword") String keyword,
                                     @Param("cityname") String cityname,
                                     @Param("studio") String studio,
                                     @Param("category") String category) {
        Session session = sessionFactory.openSession();
//        session.beginTransaction();
        String query = "select p from Package p where p.id is not null ";
        if (keyword != null) {
            query += " and concat(p.name,'',p.des,'',p.price,'',p.duration,'',p.date) like '%" + keyword + "%' ";
        }
        if (!"All".equals(cityname)) {
            query += " and p.services.city.name = '" + cityname + "' ";
        }
        if (!"All".equals(studio)) {
            query += " and p.services.studio_id = '" + studio + "' ";
        }
        if (!"All".equals(category)) {
            query += " and p.services.category.id = '" + category + "' ";
        }
        Query<Package> query1 = session.createQuery(query, Package.class);
        return query1.getResultList();
//        session.getTransaction().commit();
//        session.close();
//        return modelMapper.mapList(packageRepository.getPackageByFields(keyword, cityname, studio, category), PackageDTO.class);
    }

    //get all packages
    @Override
    public List<PackageDTO> getAllPackagesByKeyword(String keyword) {
        List<Package> packages = packageRepository.getAllInformationOfPackages(keyword);
        return modelMapper.mapList(packages, PackageDTO.class);
    }

    @Override
    public List<PackageDTO> getAllInforPackage() {
        List<PackageDTO> list = new ArrayList<>();
        List<Package> packages = packageRepository.getAllInformationOfPackage();
        for (Package p : packages) {
            list.add(modelMapper.map(p, PackageDTO.class));
        }
        return list;
    }

    //get package by id
    @Override
    public PackageDTO getPackageById(String id) {
        Package p = packageRepository.getById(id);
        PackageDTO packageDTO = new PackageDTO();
        ModelMapper mapper = new ModelMapper();
        packageDTO = mapper.map(p, PackageDTO.class);
        return packageDTO;
    }

    //add new package
    @Override
    public Package save(PackageDTO p) {
        Package aPackage = new Package();
        aPackage.setName(p.getName());
        aPackage.setDuration(p.getDuration());
        aPackage.setPrice(p.getPrice());
        aPackage.setDes(p.getDes());
        aPackage.setStatus(true);
        return packageRepository.save(aPackage);
    }

    //update
    @Override
    public Package update(PackageDTO p) {
        try {
            Package aPackage = packageRepository.getById(p.getId());
            aPackage.setName(p.getName());
            aPackage.setDuration(p.getDuration());
            aPackage.setPrice(p.getPrice());
            aPackage.setDes(p.getDes());
            return packageRepository.save(aPackage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //disable package
    @Override
    public void disablePackageById(String id) {
        Package p = packageRepository.getById(id);
        p.setStatus(false);
        packageRepository.save(p);
    }

    //enable package
    @Override
    public void enablePackageById(String id) {
        Package p = packageRepository.getById(id);
        p.setStatus(true);
        packageRepository.save(p);
    }

    @Override
    public Page<Package> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return packageRepository.findAll(pageable);
    }

    @Override
    public List<Package> searchPackage(String key) {
        return null;
    }

    @Override
    public PackageDTO getPackageByServiceId(String serviceId) {
        return modelMapper.map(packageRepository.getPackageByServicesId(serviceId), PackageDTO.class);
    }

    @Override
    public List<PackageDTO> getAllPackagesByCity(String city_name) {
        List<PackageDTO> list = new ArrayList<>();
        List<Package> packages = packageRepository.getPackageByCity(city_name);
        for (Package p : packages) {
            list.add(modelMapper.map(p, PackageDTO.class));
        }
        return list;
    }

    @Override
    public List<PackageDTO> getAllPackagesByCityAndSearch(String city_name, String keyword) {
        return modelMapper.mapList(packageRepository.getPackageByCityAndSearch(city_name, keyword), PackageDTO.class);
    }

    @Override
    public List<PackageDTO> getAllPackageByStudio(String studio_id) {
        return modelMapper.mapList(packageRepository.getPackageByStudio(studio_id), PackageDTO.class);
    }

    @Override
    public List<PackageDTO> getPackageByStudioAndSearchAndCategory(String keyword, String studioid, String categoryname) {
        return modelMapper.mapList(packageRepository.getPackageByStudioAndSearchAndCategory(keyword, studioid, categoryname), PackageDTO.class);
    }


}
