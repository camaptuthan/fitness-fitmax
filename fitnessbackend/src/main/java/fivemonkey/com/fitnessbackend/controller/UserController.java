package fivemonkey.com.fitnessbackend.controller;


import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.Role;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //user register
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") UserDTO user, RedirectAttributes attributes) {
        List<Object> userPresentObj = userService.isUserPresent(user);
        String phone =user.getPhone();
        if((Boolean) userPresentObj.get(0)|| !phone.matches("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$")){
            attributes.addFlashAttribute("fail", userPresentObj.get(1));
            attributes.addFlashAttribute("regexPhone", "Phone Must Be Matches (+84) 35 539-0605;");
            return "redirect:/register";
        }

       userService.registerUser(user.getEmail(),user.getPassword(),phone,user.getFirstName(),user.getLastName());
       attributes.addFlashAttribute("message","Register Successfully");
       return "redirect:/register";
    }
     //get user

    //login
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user")  UserDTO u,RedirectAttributes redirectAttributes,HttpSession httpSession){
        User userLogin=userService.login(u);
        if(userLogin==null){
            redirectAttributes.addFlashAttribute("fail","Email or Password Invalid!!");
            return "redirect:/login";
        }

        //check object

        return "redirect:/dashboard";
    }
}
