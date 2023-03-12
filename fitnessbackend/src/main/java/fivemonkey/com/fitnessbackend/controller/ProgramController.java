package fivemonkey.com.fitnessbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/program")
public class ProgramController {
    @GetMapping("/")
    public String program() {
        return "/program";
    }
}
