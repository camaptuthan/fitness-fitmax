package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.ServiceTypeDTO;
import fivemonkey.com.fitnessbackend.service.service.ServiceTypeService;
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

}
