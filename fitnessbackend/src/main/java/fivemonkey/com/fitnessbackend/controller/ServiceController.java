package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    ServiceService serviceService;


    @GetMapping("/")
    public String service() {
        return "/service";
    }


    @GetMapping("/admin-service/page")
    public String getAllServiceAdminPage(Model model) {
        List<Services> list = serviceService.getAll();
        System.out.println(list.size());
        model.addAttribute("list", list);
        return "/admin-service";
    }

    @GetMapping("/admin-service")
    public String serviceAdmin() {
        return "management/dashboard/service";
    }
}
