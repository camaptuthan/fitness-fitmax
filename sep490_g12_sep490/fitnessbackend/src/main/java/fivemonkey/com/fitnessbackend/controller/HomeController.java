package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.exceptionhandler.UserNotFoundException;
import fivemonkey.com.fitnessbackend.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ServiceService serviceService;

    @GetMapping("/")
    public String getAllService(Model model) {
        List<Services> list = serviceService.getAll();
        System.out.println(list.size());
        model.addAttribute("list", list);

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
