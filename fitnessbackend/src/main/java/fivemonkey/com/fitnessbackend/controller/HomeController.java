package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.ServiceTypeDTO;
import fivemonkey.com.fitnessbackend.entities.ServiceType;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.exceptionhandler.UserNotFoundException;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.services.ServiceService;
import fivemonkey.com.fitnessbackend.services.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    @GetMapping("/blog-writer")
    public String blogWriter() {
        return "/blog_writer";
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
    public String dashboard(@AuthenticationPrincipal UserDetail userDetail) {
        if(userDetail==null){
            return "redirect:/login";
        }else if(userDetail.getUser().getRole().getId().equals("ROLE0001")){
            return "/management/Dashboard/index";
        }else{
            return "/management/403";
        }
//        String msg = null;
//        if(msg == null) {
//            UserNotFoundException userNotFoundException = new UserNotFoundException("User Not Found");
//            throw userNotFoundException;
//        }

    }

    @GetMapping("/managestudio")
    public String studioAdmin() {
        return "management/StudioManagement/manage_studio";
    }


}
