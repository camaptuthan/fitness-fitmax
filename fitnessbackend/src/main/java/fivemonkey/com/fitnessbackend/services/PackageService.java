package fivemonkey.com.fitnessbackend.services;


import fivemonkey.com.fitnessbackend.dto.PackageDTO;

import fivemonkey.com.fitnessbackend.entities.Package;
import fivemonkey.com.fitnessbackend.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.parameters.P;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import java.util.List;

public interface PackageService {

    List<PackageDTO> getAll();

    public List<PackageDTO> getAllPackagesByKeyword(String keyword);

    List<PackageDTO> getAllInforPackage();

    public PackageDTO getPackageById(String id);

    public Package save(PackageDTO p);

    public Package update(PackageDTO p);

    public void disablePackageById(String id);

    public void enablePackageById(String id);

    Page<Package> findPaginated(int pageNo, int pageSize);

    public List<Package> searchPackage(String key);
    PackageDTO getPackageByServiceId(String serviceId);

    List<PackageDTO> getAllPackagesByCity(String city_name);

    List<PackageDTO> getAllPackagesByCityAndSearch(String city_name, String keyword);

//    List<PackageDTO> getAllPackageByStudio(String email);
}
