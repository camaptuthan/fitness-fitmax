package fivemonkey.com.fitnessbackend.controller;


import fivemonkey.com.fitnessbackend.configuration.Utility;
import fivemonkey.com.fitnessbackend.dto.RegistrationDTO;
import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.Role;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.imageuploader.ImageUploader;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.services.RegistrationService;
import fivemonkey.com.fitnessbackend.services.RoleService;
import fivemonkey.com.fitnessbackend.services.StudioService;
import fivemonkey.com.fitnessbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    StudioService studioService;
    @Autowired
    private ImageUploader imageUploader;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/management/listusers")
    public String listUser(Model model, @Param("keyword") String keyword) {
        List<UserDTO> userDTOList = userService.findAll();
        List<UserDTO> userDTOList1 = userService.findAllUser(keyword);
        List<Role> roleList = roleService.getAll();
        if (keyword == null || "---All---".equals(keyword)) {
            model.addAttribute("listRole", roleList);
            model.addAttribute("list", userDTOList);
            model.addAttribute("size", userDTOList.size());
        } else {
            model.addAttribute("listRole", roleList);
            model.addAttribute("list", userDTOList1);
            model.addAttribute("keyword", keyword);
            model.addAttribute("size", userDTOList1.size());

        }
        return "management/UserManagement/UserList";

    }


    @PostMapping("/management/saveuser")
    public String saveUser(@ModelAttribute("user") UserDTO userDTO, RedirectAttributes ra) {
        try {
            userService.save(userDTO);
            ra.addFlashAttribute("success", "Update successfully");
        } catch (Exception e) {
            e.printStackTrace();
            ra.addFlashAttribute("fail", "Update failed");
        }
        return "redirect:/user/management/listusers";
    }

    @RequestMapping(value = "/management/enableuser/{email}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String enableUser(@PathVariable("email") String email, RedirectAttributes ra) {
        try {
            userService.enableById(email);
            ra.addFlashAttribute("success", "Enable successfully");
        } catch (Exception e) {
            e.printStackTrace();
            ra.addFlashAttribute("fail", "Enable failed");
        }
        return "redirect:/user/management/listusers";
    }

    @RequestMapping(value = "/management/disableuser/{email}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String disableUser(@PathVariable("email") String email, RedirectAttributes ra) {
        try {
            userService.disableUser(email);
            ra.addFlashAttribute("success", "disable successfully");
        } catch (Exception e) {
            e.printStackTrace();
            ra.addFlashAttribute("fail", "disable failed");
        }
        return "redirect:/user/management/listusers";
    }

    @RequestMapping("/management/updateuser/{email}")
    public String getInformationUser(@PathVariable("email") String email, Model model) {
        List<Role> roleList = roleService.getAll();
        List<Studio> studioList = studioService.getAllStudios();
        UserDTO userDTO = userService.getUserById(email);

        model.addAttribute("user", userDTO);
        model.addAttribute("listRole", roleList);
        model.addAttribute("listStudio", studioList);
        return "management/usermanagement/userupdate";
    }

    @PostMapping("/management/updateuser/{email}")
    public String userUpdate(@PathVariable("email") String email, @ModelAttribute("user") UserDTO userDTO, RedirectAttributes ra) {
        try {
            userService.update(userDTO);
            System.out.println(userDTO);
            ra.addFlashAttribute("success", "Update Successfully");
        } catch (Exception e) {
            e.printStackTrace();
            ra.addFlashAttribute("fail", "Fail");
        }
        return "redirect:/user/management/listusers";


    }

    @RequestMapping("/search")
    public String search(Model model, @Param("keyword") String keyword) {
        List<UserDTO> userList = userService.findAllUser(keyword);
        System.out.println("=====================hjkd==============mai========" + userList);
        model.addAttribute("list", userList);
        return "management/usermanagement/userlist";
    }

    @RequestMapping("/management/avatauser/{email}")
    public String getInformationUserPro5(@PathVariable("email") String email, Model model) {
        UserDTO userDTO = userService.getUserById(email);
        model.addAttribute("user", userDTO);
        return "management/usermanagement/userProfile";
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


//        claimDocument.setFileUrl(String.format(FireBaseConstant.FILE_URL, fileName));

//        claimDocument.setFileUrl(String.format(FireBaseConstant.FILE_URL, fileName));

        userDTO.setAvatar(imageUploader.upload(multipartFile));
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

        System.out.println("-0jodjf==================================================siodhfoisd=======" + userDTO);


        return "redirect:/listusers";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
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


    @GetMapping("/profile")
    public String myProfile(@AuthenticationPrincipal UserDetail userDetail, Model model) {
        model.addAttribute("user", userDetail.getUser());
        return "user/profile";
    }
    @ResponseBody
    @GetMapping("/profile/registration")
    public List<RegistrationDTO> registration(@AuthenticationPrincipal UserDetail userDetail) {
        return registrationService.getRegistrationByUserEmail(userDetail.getUser().getEmail());
    }


}








