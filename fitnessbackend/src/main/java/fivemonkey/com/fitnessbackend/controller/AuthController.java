package fivemonkey.com.fitnessbackend.controller;


import fivemonkey.com.fitnessbackend.dto.LoginDTO;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class AuthController {

    private AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        super();
        this.authenticationManager = authenticationManager;
    }

    @GetMapping
    public String loginPage(Model model, @RequestParam(required = false) String errorMsg, @RequestParam(required = false, defaultValue = "false") String register) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("loginDto", new LoginDTO());
        model.addAttribute("errorMsg", errorMsg);
        model.addAttribute("register", register);
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "/login";
        }
        authentication.getAuthorities().forEach(a -> {
            System.out.println("role: " + a.getAuthority());
        });
        return "redirect:/";
    }

    @PostMapping
    public String signIn(@ModelAttribute("loginDto") LoginDTO loginDTO) {
        System.out.println(loginDTO.getUsername());
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/";
    }

}
