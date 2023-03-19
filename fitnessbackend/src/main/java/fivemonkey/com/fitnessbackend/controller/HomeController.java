package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.services.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private ServiceTypeService serviceTypeService;

    @GetMapping("/")
    public String getAllServiceType(@AuthenticationPrincipal UserDetail userDetail, Model model) {
        String path = "/index";
        //return "fragments/home_program";
        return path;
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
        return "/management/Dashboard/index";

    }

    @GetMapping("/managestudio")
    public String studioAdmin() {
        return "management/StudioManagement/manage_studio";
    }


}
