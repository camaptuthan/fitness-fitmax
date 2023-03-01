package fivemonkey.com.fitnessbackend.controller;


import fivemonkey.com.fitnessbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/users")
//    public List<User> getUsers(){
//        return userService.getUsers();
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public void registerUser(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password){
//         userService.registerUser(new User(email, password));
//    }

    @GetMapping("/profile/{id}")
    public String getProfile() {
        return "myprofile";
    }
}
