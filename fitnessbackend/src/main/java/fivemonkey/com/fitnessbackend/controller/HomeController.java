package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.ServiceTypeDTO;
import fivemonkey.com.fitnessbackend.entities.ServiceType;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.exceptionhandler.UserNotFoundException;
import fivemonkey.com.fitnessbackend.services.ServiceService;
import fivemonkey.com.fitnessbackend.services.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ServiceTypeService serviceTypeService;

    @GetMapping("/")
    public String getAllServiceType(Model model) {
        List<ServiceTypeDTO> listServiceType = serviceTypeService.getAll();
        model.addAttribute("listServiceType", listServiceType);
        //return "fragments/home_program";
        return "/index";
    }

    @GetMapping("/register")
    public String register() {
        return "/register";
    }

    @GetMapping("/reset-password")
    public String resetPassword() {
        return "/reset_password";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        String msg = null;
        if(msg == null) {
            UserNotFoundException userNotFoundException = new UserNotFoundException("User Not Found");
            throw userNotFoundException;
        }
        return "management/dashboard/index";
    }


}
