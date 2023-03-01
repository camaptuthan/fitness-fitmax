package fivemonkey.com.fitnessbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

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

    @GetMapping("/blog")
    public String blog() {
        return "/blog";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
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
    public String dashboard(){
        return "management/dashboard/index";
    }

    @GetMapping("/admin-service")
    public String serviceAdmin(){
        return "management/dashboard/service";
    }


}
