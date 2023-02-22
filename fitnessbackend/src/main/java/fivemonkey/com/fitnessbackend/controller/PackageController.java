package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.entity.Package;
import fivemonkey.com.fitnessbackend.services.PackageService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/package")
public class PackageController {

    @Autowired
    private PackageService packageServices;

    //view all packages
    @GetMapping("/packages")
    public String getAllPackages(Model model) {
        List<Package> packageList = packageServices.getAllPackages();
        model.addAttribute("packageList", packageList);
        return "management/PackageManagement/packageList";
    }

    //add new packages
    @PostMapping("/add")
    public void addPackage(@RequestBody Package p) {
        packageServices.addPackage(p);
    }

    //view package by Id
    @GetMapping("/package_detail/{id}")
    public String viewPackageDetail(@PathVariable(name = "id") Long id, Model model) {
        Package p = packageServices.getPackageById(id);
        model.addAttribute("package", p);
        return "management/PackageManagement/packageDetail";
    }
}
