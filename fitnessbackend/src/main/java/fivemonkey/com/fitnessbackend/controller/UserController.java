package fivemonkey.com.fitnessbackend.controller;


import fivemonkey.com.fitnessbackend.configuration.Utility;
import fivemonkey.com.fitnessbackend.constant.FireBaseConstant;
import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.Role;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.services.RoleService;
import fivemonkey.com.fitnessbackend.services.StudioService;
import fivemonkey.com.fitnessbackend.services.UserService;
import fivemonkey.com.fitnessbackend.utils.FireBaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


@Controller

public class UserController {
    @Autowired
    FireBaseUtils fireBaseUtils;
    @Autowired
    RoleService roleService;
    @Autowired
    StudioService studioService;
    @Autowired
    private UserService userService;


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

    @RequestMapping("/search")
    public String search(Model model, @Param("keyword") String keyword) {
        List<User> userList = userService.findAllUser(keyword);
        System.out.println("=====================hjkd==============mai========" + userList);
        model.addAttribute("list", userList);
        return "management/usermanagement/userlist";
    }

    @RequestMapping("/avatauser/{email}")
    public String getInformationUserPro5(@PathVariable("email") String email, Model model) {
        List<Role> roleList = roleService.getAll();
        List<Studio> studioList = studioService.getAll();
        UserDTO userDTO = userService.getUserById(email);
        model.addAttribute("user", userDTO);

        return "pro";
    }
//@GetMapping("/search")
//    public String search(Model model, @RequestParam(name = "email",required = false) String email){
//    List<User> userList = null;
//    if (StringUtils.hasText(email)){
//        userList = userService.findAllUserNameContaining(email);}
//    else{
//        userList = userService.findAllUser();
//        }
//    model.addAttribute("list",userList);
//    return "management/usermanagement/userlist";


    @PostMapping("/avatauser/{email}")
    public String userUpdate(@RequestParam("fileImage") MultipartFile multipartFile,

                             @ModelAttribute("user") UserDTO userDTO,
                             Model model) throws IOException {
        //save user


        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        fireBaseUtils.uploadFile(multipartFile, fileName);
        String url = FireBaseConstant.FILE_URL.toString();
//        claimDocument.setFileUrl(String.format(FireBaseConstant.FILE_URL, fileName));
        userDTO.setAvatar(String.format(FireBaseConstant.FILE_URL, fileName));


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


        userService.updateUser(userDTO);
        System.out.println("-0jodjf==================================================siodhfoisd=======" + userDTO);


        return "redirect:/listusers";
    }


    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("userDTO") User user, RedirectAttributes attributes, HttpServletRequest request, BindingResult bindingResult) throws MessagingException, UnsupportedEncodingException {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        List<Object> userPresentObj = userService.isUserPresent(user);
        String phone = user.getPhone();
        String siteUrl = Utility.getSiteURL(request);
        if ((Boolean) userPresentObj.get(0) || !phone.matches("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$")) {
            attributes.addFlashAttribute("fail", userPresentObj.get(1));
            attributes.addFlashAttribute("regexPhone", "Phone Must Be Matches (+84) 35 539-0605;");
            return "redirect:/register";
        }
        userService.registerUser(user);
        userService.sendVerificationEmail(user, siteUrl);
        attributes.addFlashAttribute("message", "You have to registered as a member.");
        attributes.addFlashAttribute("message2", "Please check your email verify account ");
        return "redirect:/register";
    }

    //handle verify
    @GetMapping("/verify")
    public String verifyAccount(@Param("code") String code, Model model) {
        boolean verified = userService.verify(code);
        String title = verified ? "Verification Success" : "Verification Failed";
        model.addAttribute("title", title);
        return "/register";
    }
}








