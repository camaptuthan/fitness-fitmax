package fivemonkey.com.fitnessbackend.controller;


import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.Role;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.services.IStudioService;
import fivemonkey.com.fitnessbackend.services.RoleService;
import fivemonkey.com.fitnessbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller

public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    IStudioService studioService;
    //login

    @GetMapping("/listusers")
    public String listUser(Model model) {
        List<UserDTO> userDTOList = userService.findAll();
        model.addAttribute("list", userDTOList);
        model.addAttribute("size", userDTOList.size());
        return "management/usermanagement/userlist";
    }

    @PostMapping("/saveuser")
    public String saveUser(@ModelAttribute("user") UserDTO userDTO, RedirectAttributes ra) {
        try {
            userService.save(userDTO);
            ra.addFlashAttribute("success", "Update successfully");
        } catch (Exception e) {
            e.printStackTrace();
            ra.addFlashAttribute("fail", "Update failed");
        }
        return "redirect:/listusers";
    }

    @RequestMapping(value = "/enableuser/{email}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String enableUser(@PathVariable("email") String email, RedirectAttributes ra) {
        try {
            userService.enableById(email);
            ra.addFlashAttribute("success", "Enable successfully");
        } catch (Exception e) {
            e.printStackTrace();
            ra.addFlashAttribute("fail", "Enable failed");
        }
        return "redirect:/listusers";
    }

    @RequestMapping(value = "/disableuser/{email}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String disableUser(@PathVariable("email") String email, RedirectAttributes ra) {
        try {
            userService.disableUser(email);
            ra.addFlashAttribute("success", "disable successfully");
        } catch (Exception e) {
            e.printStackTrace();
            ra.addFlashAttribute("fail", "disable failed");
        }
        return "redirect:/listusers";
    }

    @RequestMapping("updateuser/{email}")
    public String getInformationUser(@PathVariable("email") String email, Model model) {
        List<Role> roleList = roleService.getAll();
        List<Studio> studioList = studioService.getAllStudios();
        UserDTO userDTO = userService.getClassById(email);
        model.addAttribute("user", userDTO);
        model.addAttribute("listRole", roleList);
        model.addAttribute("listStudio", studioList);
        return "management/usermanagement/userupdate";
    }

    @PostMapping("/updateuser/{email}")
    public String userUpdate(@PathVariable("email") String email, @ModelAttribute("user") UserDTO userDTO, RedirectAttributes ra) {
        try {
            userService.update(userDTO);
            System.out.println(userDTO);
            ra.addFlashAttribute("success", "Update Successfully");
        } catch (Exception e) {
            e.printStackTrace();
            ra.addFlashAttribute("fail", "Fail");
        }
        return "redirect:/listusers";


    }

    @GetMapping("/search")
    public String search(Model model) {
        String email = "ha";
        List<User> userList = userService.findAllUserNameContaining(email);
        model.addAttribute("list", userList);
        return "management/usermanagement/userlist";


    }

    @GetMapping("/test-html")
    public String testHTML(){
        return "management/usermanagement/user-profile";
    }

}



