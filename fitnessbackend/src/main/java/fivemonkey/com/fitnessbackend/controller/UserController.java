package fivemonkey.com.fitnessbackend.controller;


import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.Role;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/register-user", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") UserDTO user,Model model) {
        List<Object> userPresentObj = userService.isUserPresent(user);
        if((Boolean) userPresentObj.get(0)){
            model.addAttribute("successMessage", userPresentObj.get(1));
            return "/register";
        }

       userService.registerUser(user.getEmail(),user.getPassword(),user.getPhone());
       model.addAttribute("message","Register Successfully");
       return "/login";
    }
}
