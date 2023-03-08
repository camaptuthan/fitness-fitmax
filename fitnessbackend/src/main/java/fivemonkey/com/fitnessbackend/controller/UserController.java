package fivemonkey.com.fitnessbackend.controller;


import fivemonkey.com.fitnessbackend.constant.FireBaseConstant;

import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.Role;
import fivemonkey.com.fitnessbackend.entities.Studio;

import fivemonkey.com.fitnessbackend.services.IStudioService;
import fivemonkey.com.fitnessbackend.services.RoleService;

import fivemonkey.com.fitnessbackend.services.UserService;
import fivemonkey.com.fitnessbackend.utils.FireBaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;


@Controller

public class UserController {
    @Autowired
    private FireBaseUtils fireBaseUtils;
    @Autowired
    private RoleService roleService;
    @Autowired
    private IStudioService studioService;
    @Autowired
    private UserService userService;

    @GetMapping("/listusers")
    public String listUser(Model model, @Param("keyword") String keyword ) {
        List<UserDTO> userDTOList = userService.findAll();
        List<UserDTO> userDTOList1 = userService.findAllUser(keyword);
        List<Role> roleList = roleService.getAll();
        if(keyword == null || "---All---".equals(keyword)){
            model.addAttribute("listRole", roleList);
            model.addAttribute("list", userDTOList);
            model.addAttribute("size", userDTOList.size());
        } else {
            model.addAttribute("listRole", roleList);
            model.addAttribute("list",userDTOList1);
            model.addAttribute("keyword",keyword);
            model.addAttribute("size",userDTOList1.size());

        }
        return "management/UserManagement/UserList";

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
        UserDTO userDTO = userService.getUserById(email);

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



    @RequestMapping("/avatauser/{email}")
    public String getInformationUserPro5(@PathVariable("email") String email, Model model) {
        List<Role> roleList = roleService.getAll();
        List<Studio> studioList = studioService.getAll();
        UserDTO userDTO = userService.getUserById(email);
        model.addAttribute("user", userDTO);

        return "management/usermanagement/userProfile";
    }

    @PostMapping("/avatauser/{email}")
    public String userUpdate(@RequestParam("fileImage") MultipartFile multipartFile,

                             @ModelAttribute("user") UserDTO userDTO,
                             Model model) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        fireBaseUtils.uploadFile(multipartFile, fileName);
        userDTO.setAvatar(String.format(FireBaseConstant.FILE_URL, fileName));
        userService.updateUser(userDTO);

//        String uploadDir = "./src/main/resources/static/avatar/" + userDTO.getEmail();
//
//        Path uploadPath = Paths.get(uploadDir);

//        if(!Files.exists(uploadPath)) {
//            Files.createDirectories(uploadPath);
//        }
//
//        try (InputStream inputStream = multipartFile.getInputStream()) {
//            Path filePath = uploadPath.resolve(fileName);
//            Files.copy(inputStream, filePath , StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            throw new IOException("Could not save uploaded file: " + fileName);
//        }

//
//        userService.updateUser(userDTO);
//        System.out.println("-0jodjf==================================================siodhfoisd=======" + userDTO);


        return "redirect:/listusers";
    }


}



