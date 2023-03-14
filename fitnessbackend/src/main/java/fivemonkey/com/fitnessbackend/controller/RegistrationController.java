package fivemonkey.com.fitnessbackend.controller;


import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/make")
    public String doRegistration(@RequestParam("item_id") String itemId, @AuthenticationPrincipal UserDetail userDetail) {
        registrationService.doRegistration(userDetail.getUser(), itemId);
        return "redirect:/user/profile";
    }
}
