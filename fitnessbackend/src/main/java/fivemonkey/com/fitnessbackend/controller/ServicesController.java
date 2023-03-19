package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.ServicesDTO;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.service.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service")
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    @Autowired
    private ModelMapperConfiguration<Services, ServicesDTO> modelMapper;


}
