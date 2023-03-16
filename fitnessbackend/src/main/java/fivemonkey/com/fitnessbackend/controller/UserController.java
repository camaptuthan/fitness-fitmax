package fivemonkey.com.fitnessbackend.controller;


import com.google.gson.Gson;
import fivemonkey.com.fitnessbackend.configuration.Utility;
import fivemonkey.com.fitnessbackend.dto.RegistrationDTO;
import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.City;
import fivemonkey.com.fitnessbackend.entities.Role;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.imageuploader.ImageUploader;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.services.*;
import org.hibernate.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
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


//    @GetMapping("/management/listusers")
//    public String listUser(Model model, @Param("keyword") String keyword,@AuthenticationPrincipal UserDetail userDetail) {
//        List<UserDTO> userDTOList = userService.findAll();
//        List<UserDTO> listManager = userService.listByManager(userDetail.getUser().getStudio().getId());
//        List<UserDTO> listCityAdmin = userService.listByCityAdmin(userDetail.getUser().getStudio().getDistrict().getCity().getName());
//        List<UserDTO> listAssistant = userService.listByAssistant(userDetail.getUser().getStudio().getId());
//        List<UserDTO> userSearch = userService.findAllUser(keyword);
//        List<Role> roleList = roleService.getAll();
//        switch(userDetail.getUser().getRole().getId()){
//            case"ROLE0001":
//                if (keyword == null || "---All---".equals(keyword)) {
//                    model.addAttribute("listRole", roleList);
//                    model.addAttribute("list", userDTOList);
//                    model.addAttribute("size", userDTOList.size());
//                } else {
//                    model.addAttribute("listRole", roleList);
//                    model.addAttribute("list", userSearch);
//                    model.addAttribute("keyword", keyword);
//                    model.addAttribute("size",userSearch.size());
//                }
//            case"ROLE0006":
//                if (keyword == null || "---All---".equals(keyword)) {
//                    model.addAttribute("listRole", roleList);
//                    model.addAttribute("list", listCityAdmin);
//                    model.addAttribute("size", listCityAdmin.size());
//                } else {
//                    model.addAttribute("listRole", roleList);
//                    model.addAttribute("list", userSearch);
//                    model.addAttribute("keyword", keyword);
//                    model.addAttribute("size",userSearch.size());
//                }
//            case"ROLE0002":
//                if (keyword == null || "---All---".equals(keyword)) {
//                    model.addAttribute("listRole", roleList);
//                    model.addAttribute("list", listManager);
//                    model.addAttribute("size", listManager.size());
//                } else {
//                    model.addAttribute("listRole", roleList);
//                    model.addAttribute("list", userSearch);
//                    model.addAttribute("keyword", keyword);
//                    model.addAttribute("size",userSearch.size());
//                }
//            case"ROLE0004":
//                if (keyword == null || "---All---".equals(keyword)) {
//                    model.addAttribute("listRole", roleList);
//                    model.addAttribute("list", listAssistant);
//                    model.addAttribute("size", listAssistant.size());
//                } else {
//                    model.addAttribute("listRole", roleList);
//                    model.addAttribute("list", userSearch);
//                    model.addAttribute("keyword", keyword);
//                    model.addAttribute("size",userSearch.size());
//                }
//
//
//        }
//
//        return "management/UserManagement/UserList";
//
//    }
//    @GetMapping("/management/listusers")
//    public String listUser(Model model, @Param("keyword") String keyword,@AuthenticationPrincipal UserDetail userDetail) {
//        List<UserDTO> userDTOList = userService.findAll();
//        List<UserDTO> listManager = userService.listByManager(userDetail.getUser().getStudio().getId());
//        List<UserDTO> listCityAdmin = userService.listByCityAdmin(userDetail.getUser().getStudio().getDistrict().getCity().getName());
//        List<UserDTO> listAssistant = userService.listByAssistant(userDetail.getUser().getStudio().getId());
//        List<UserDTO> userSearch = userService.findAllUser(keyword);
//        List<Role> roleList = roleService.getAll();
//        switch(userDetail.getUser().getRole().getId()){
//            case"ROLE0001":
//                if (keyword == null || "---All---".equals(keyword)) {
//                    model.addAttribute("listRole", roleList);
//                    model.addAttribute("list", userDTOList);
//                    model.addAttribute("size", userDTOList.size());
//                } else {
//                    model.addAttribute("listRole", roleList);
//                    model.addAttribute("list", userSearch);
//                    model.addAttribute("keyword", keyword);
//                    model.addAttribute("size",userSearch.size());
//                }
//            case"ROLE0006":
//                if (keyword == null || "---All---".equals(keyword)) {
//                    model.addAttribute("listRole", roleList);
//                    model.addAttribute("list", listCityAdmin);
//                    model.addAttribute("size", listCityAdmin.size());
//                } else {
//                    model.addAttribute("listRole", roleList);
//                    model.addAttribute("list", userSearch);
//                    model.addAttribute("keyword", keyword);
//                    model.addAttribute("size",userSearch.size());
//                }
//            case"ROLE0002":
//                if (keyword == null || "---All---".equals(keyword)) {
//                    model.addAttribute("listRole", roleList);
//                    model.addAttribute("list", listManager);
//                    model.addAttribute("size", listManager.size());
//                } else {
//                    model.addAttribute("listRole", roleList);
//                    model.addAttribute("list", userSearch);
//                    model.addAttribute("keyword", keyword);
//                    model.addAttribute("size",userSearch.size());
//                }
//            case"ROLE0004":
//                if (keyword == null || "---All---".equals(keyword)) {
//                    model.addAttribute("listRole", roleList);
//                    model.addAttribute("list", listAssistant);
//                    model.addAttribute("size", listAssistant.size());
//                } else {
//                    model.addAttribute("listRole", roleList);
//                    model.addAttribute("list", userSearch);
//                    model.addAttribute("keyword", keyword);
//                    model.addAttribute("size",userSearch.size());
//                }
//
//
//        }
//
//        return "management/UserManagement/UserList";
//
//    }



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
        return "management/UserManagement/UserUpdate";
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
        model.addAttribute("list", userList);
        return "management/usermanagement/userlist";
    }

    @RequestMapping("/management/avataruser/{email}")
    public String getInformationUserAvatar(@PathVariable("email") String email, Model model) {
        UserDTO userDTO = userService.getUserById(email);
        model.addAttribute("user", userDTO);
        return "pro";
    }

    @PostMapping("/management/avataruser/{email}")
    public String userUpdate(@RequestParam("fileImage") MultipartFile multipartFile,

                             @ModelAttribute("user") UserDTO userDTO,
                             Model model) throws IOException {

        userDTO.setAvatar(imageUploader.upload(multipartFile));

        userService.updateUserAvatar(userDTO);

        return "redirect:/user/management/listusers";
    }

    @RequestMapping("/management/updateprofile/{email}")
    public String getInformationUserPro5(@PathVariable("email") String email, Model model) {
        UserDTO userDTO = userService.getUserById(email);
        model.addAttribute("user", userDTO);
        return "myprofile";
    }

    @PostMapping("/management/updateprofile/{email}")
    public String userUpdateAll(@ModelAttribute("user") UserDTO userDTO, Model model) throws IOException {
        userService.updateUser(userDTO);
        return "redirect:/user/management/listusers";
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
        String title = verified ? "Congratulation! Your account has created success" : "Your account already verified code";
        model.addAttribute("title", title);
        return "/verify_status";
    }


    @GetMapping("/profile")
    public String myProfile(@AuthenticationPrincipal UserDetail userDetail, Model model) {
        model.addAttribute("registrations", registrationService.getRegistrationsByUserEmail(userDetail.getUser().getEmail()));
        model.addAttribute("user", userDetail.getUser());
        return "user/profile";
    }

    @ResponseBody
    @GetMapping("/profile/registration")
    public List<RegistrationDTO> registration(@AuthenticationPrincipal UserDetail userDetail) {
        return registrationService.getRegistrationsByUserEmail(userDetail.getUser().getEmail());
    }

    //Change Password
    @GetMapping("/profilechangepassword")
    public String changePassword(@AuthenticationPrincipal UserDetail userDetail, Model model) {
        model.addAttribute("user", userDetail.getUser());
        return "user/changepassword";
    }

    @PostMapping("/changepassword")
    public String passwordUpdate(@RequestParam("cpassword") String cpassword, @RequestParam("npassword") String npassword, @RequestParam("cnpassword") String cnpassword, @AuthenticationPrincipal UserDetail userDetail, Model model, RedirectAttributes ra) {
        String path = "redirect:/user/profile";
        try {

            if (cpassword.equals(userDetail.getUser().getPassword()) && npassword.length() >= 6) {
                ra.addFlashAttribute("success", "Change your password successfully! Please login again!");
                userDetail.getUser().setPassword(npassword);
                userService.updateUserPassword(userDetail.getUser());
                System.out.println("Password details: " + userDetail.getPassword() + "Password3: " + userDetail.getUser().getPassword() + "Current: " + cpassword + "New: " + npassword + "Confirm New" + cnpassword);

            } else if (npassword.length() < 6) {
                ra.addFlashAttribute("fail", "New password must be longer than 8 characters! Please enter new password again!");
                model.addAttribute("npassword", npassword);
                model.addAttribute("cnpassword", cnpassword);
                model.addAttribute("cpassword", cpassword);
                System.out.println("Password details: " + userDetail.getPassword() + "Password3: " + userDetail.getUser().getPassword() + "Current: " + cpassword + "New: " + npassword + "Confirm New" + cnpassword);

            } else if (!cpassword.equals(userDetail.getPassword())) {
                ra.addFlashAttribute("fail", "Current password is wrong! Please enter your password again!");
                model.addAttribute("npassword", npassword);
                model.addAttribute("cnpassword", cnpassword);
                model.addAttribute("cpassword", cpassword);
                System.out.println("Password details: " + userDetail.getPassword() + "Password3: " + userDetail.getUser().getPassword() + "Current: " + cpassword + "New: " + npassword + "Confirm New" + cnpassword);

            } else {
                ra.addFlashAttribute("fail", "Confirm new password must be different from new password! Please enter confirm new password again!");
                model.addAttribute("npassword", npassword);
                model.addAttribute("cnpassword", cnpassword);
                model.addAttribute("cpassword", cpassword);
                System.out.println("Password details: " + userDetail.getPassword() + "Password3: " + userDetail.getUser().getPassword() + "Current: " + cpassword + "New: " + npassword + "Confirm New" + cnpassword);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ra.addFlashAttribute("fail", "Fail");
        }
        System.out.println("Password details: " + userDetail.getPassword() + "Password3: " + userDetail.getUser().getPassword() + "Current: " + cpassword + "New: " + npassword + "Confirm New" + cnpassword);
        return path;
    }






    @PostMapping("/reset-password")
    public String resetPassGetOtp(@ModelAttribute("userDTO") User user, Model model,RedirectAttributes attributes) throws MessagingException, UnsupportedEncodingException {
        //validate email not exist
        List<Object> userPresentObj = userService.isUserPresent(user);
        if((Boolean) userPresentObj.get(0)){
            userService.sendOTP(user.getEmail());
            model.addAttribute("email", user.getEmail());
            return "verifyOTP";
        }
        attributes.addFlashAttribute("fail", "Email Invalid");
        return "redirect:/reset-password";

    }
    @PostMapping("/verifyOTP")
    public String verifyOTP(@RequestParam String email, @RequestParam String otp, Model model) {
        if (userService.verifyOTP(email, otp)) {
            model.addAttribute("email", email);
            return "changepass";
        } else {
            model.addAttribute("error", "Invalid OTP");
            return "verifyOTP";
        }
    }
    @PostMapping("/reset-password-result")
    public ModelAndView resetPassword(@RequestParam String email,@RequestParam String password) {
        userService.resetPassword(email,password);
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("message", "Password reset successful");
        return mav;
    }



}








