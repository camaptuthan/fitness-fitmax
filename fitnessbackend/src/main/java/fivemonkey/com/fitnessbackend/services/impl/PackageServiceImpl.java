package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.PackageDTO;
import fivemonkey.com.fitnessbackend.entities.Package;
import fivemonkey.com.fitnessbackend.repository.PackageRepository;
import fivemonkey.com.fitnessbackend.services.PackageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    ModelMapperConfiguration<Package, PackageDTO> modelMapper;
    @Autowired
    private PackageRepository packageRepository;

    @Override
    public List<PackageDTO> getAll() {
        List<PackageDTO> list = new ArrayList<>();
        List<Package> packages = packageRepository.findAll();
        for (Package p : packages) {
            list.add(modelMapper.map(p, PackageDTO.class));
        }
        return list;
    }

    //get all packages
    @Override
    public List<PackageDTO> getAllPackagesByKeyword(String keyword) {
        List<PackageDTO> list = new ArrayList<>();
        List<Package> packages = packageRepository.getAllInformationOfPackages(keyword);
        for (Package p : packages) {
            list.add(modelMapper.map(p, PackageDTO.class));
        }
        return list;
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

}
