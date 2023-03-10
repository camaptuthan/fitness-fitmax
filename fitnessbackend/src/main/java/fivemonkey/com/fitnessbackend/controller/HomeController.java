package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.entities.ServiceType;
import fivemonkey.com.fitnessbackend.services.ServiceTypeService;
import jdk.dynalink.linker.LinkerServices;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ServiceTypeService serviceTypeService;

    @GetMapping("/trainer")
    public String trainer() {
        return "/trainer";
    }

    @GetMapping("/program")
    public String program() {
        return "/program";
    }

    @GetMapping("/service")
    public String service() {
        return "/service";
    }

//    @GetMapping("/bloglist")
//    public String blog() {
//        return "management/BlogManagement/blog-list";
//    }
//
//    @GetMapping("/blogadd")
//    public String blogWriter() {
//        return "management/BlogManagement/blog-add";
//    }

    @GetMapping("")
    public String getAllServiceType(Model model) {
        List<ServiceType> serviceTypes = serviceTypeService.getAll();
        model.addAttribute("serviceTypes", serviceTypes);
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
        return "management/dashboard/index";
    }

    @GetMapping("/admin-service")
    public String serviceAdmin() {
        return "management/dashboard/service";
    }

    @GetMapping("/managestudio")
    public String studioAdmin() {
        return "management/StudioManagement/manage_studio";
    }

    @GetMapping("/sd")
    public String studioAdmind() {
        return "management/StudioManagement/add_studio";
    }

    @GetMapping("/sds")
    public String studioAdmindd() {
        return "management/StudioManagement/addstudio";
    }


}
