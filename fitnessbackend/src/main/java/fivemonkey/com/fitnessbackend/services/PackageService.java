package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.entitties.Package;
import fivemonkey.com.fitnessbackend.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    //get all packages
    public List<Package> getAllPackages(){
        return packageRepository.findAll();
    }

    //get package by id
    public Package getPackageById(Long id){
        return packageRepository.getById(id);
    }

    //add new package
    public void addPackage(Package p){
        packageRepository.save(p);
    }



}
