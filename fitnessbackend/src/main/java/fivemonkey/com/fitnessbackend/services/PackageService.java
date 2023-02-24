package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.PackageDTO;
import fivemonkey.com.fitnessbackend.entitties.Package;
import fivemonkey.com.fitnessbackend.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    //get all packages
    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    //get package by id
    public PackageDTO getPackageById(Long id) {
        Package p= packageRepository.getById(id);
        PackageDTO packageDTO= new PackageDTO();
        ModelMapper mapper= new ModelMapper();
        packageDTO=mapper.map(p,PackageDTO.class);
        return packageDTO;
    }


    //add new package
    public Package save(PackageDTO p) {
        Package aPackage =new Package();
        aPackage.setName(p.getName());
        aPackage.setDuration(p.getDuration());
        aPackage.setPrice(p.getPrice());
        aPackage.setDes(p.getDes());
        aPackage.setStatus(true);
        return packageRepository.save(aPackage);
    }

    //update
    public Package update(PackageDTO p){
        try{
            Package aPackage = new Package();
            aPackage.setName(p.getName());
            aPackage.setDuration(p.getDuration());
            aPackage.setPrice(p.getPrice());
            aPackage.setDes(p.getDes());
            return packageRepository.save(aPackage);
        }catch (Exception e){
                e.printStackTrace();
        }
        return null;
    }

    //disable package
    public void disablePackageById(Long id){
        Package p = packageRepository.getById(id);
        p.setStatus(false);
        packageRepository.save(p);
    }

    //enable package
    public void enablePackageById(Long id){
        Package p = packageRepository.getById(id);
        p.setStatus(true);
        packageRepository.save(p);
    }

}
