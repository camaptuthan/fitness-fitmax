package fivemonkey.com.fitnessbackend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/profile/{email}")

    public String getProfile(@PathVariable("email") String email, Model model) {

        return "myprofile";
    }
}
