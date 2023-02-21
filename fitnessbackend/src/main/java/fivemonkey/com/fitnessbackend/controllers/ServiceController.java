package fivemonkey.com.fitnessbackend.controllers;

import fivemonkey.com.fitnessbackend.entitties.Services;
import fivemonkey.com.fitnessbackend.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/services")
    public List<Services> getServices(){
        return serviceService.getServices();
    }

    @PostMapping("/add")
    public void addService(@RequestBody Services services){
        serviceService.addService(services);
    }
}
