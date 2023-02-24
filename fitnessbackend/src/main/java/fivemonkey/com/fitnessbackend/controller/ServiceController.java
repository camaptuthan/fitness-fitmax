package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ServiceController {

       @Autowired
       ServiceService serviceService;

       @GetMapping("/")
       public String getAllService(Model model){
             List<Services> list=serviceService.getAll();
             System.out.println(list.size());
             model.addAttribute("list",list);
             return "/index";
       }



}
