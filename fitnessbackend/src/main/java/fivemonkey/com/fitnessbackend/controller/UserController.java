package fivemonkey.com.fitnessbackend.controller;


import fivemonkey.com.fitnessbackend.configuration.Utility;
import fivemonkey.com.fitnessbackend.dto.*;
import fivemonkey.com.fitnessbackend.entities.Role;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.imageuploader.ImageUploader;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.service.service.*;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    private TrainerService trainerService;

    @Autowired
    private RegistrationService registrationService;


    @Autowired
    private AddressService addressService;

    @Autowired
    private  CityService cityService;

    @GetMapping("/management/listusers")
    public String listUser(Model model, @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword
            , @RequestParam(value = "cityName", required = false, defaultValue = "All") String cityName
            , @RequestParam(value = "roleId", required = false, defaultValue = "All") String roleId
            , @RequestParam(value = "studioId", required = false, defaultValue = "All") String studioId
            , @AuthenticationPrincipal UserDetail userDetail) {
        switch (userDetail.getUser().getRole().getId()) {

            case "ROLE01":
                model.addAttribute("listCity",addressService.getCities());
                model.addAttribute("listStudio",addressService.getStudioByCity(cityName));
                model.addAttribute("listRole", roleService.getRoleAdmin());
                model.addAttribute("list", userService.getUserBy4Fields(keyword, cityName, roleId, studioId));
                model.addAttribute("size", userService.getUserBy4Fields(keyword, cityName, roleId, studioId).size());
                break;
            case "ROLE02":
                model.addAttribute("list", userService.listUserByManage(userDetail.getUser().getStudio().getId()));
                model.addAttribute("size", userService.listUserByManage(userDetail.getUser().getStudio().getId()).size());
                break;
            case "ROLE04":
                model.addAttribute("list", userService.listUserByAssistant(userDetail.getUser().getStudio().getId()));
                model.addAttribute("size", userService.listUserByAssistant(userDetail.getUser().getStudio().getId()).size());
                break;
        }
        model.addAttribute("currentStudio",studioId);
        model.addAttribute("currentKeyword", keyword);
        model.addAttribute("currentCity", cityName);
        model.addAttribute("currentRole", roleId);
        return "management/UserManagement/UserList";
    }


    @RequestMapping(value = "/listpt", method = {RequestMethod.GET, RequestMethod.POST})
    public String getPT(Model model, @RequestParam(value = "studioId", required = false, defaultValue = "") String studioId) {

        Map<String, List<TrainerDTO>> trainerMapList = new HashMap<>();
        List<TrainerDTO> listPT = trainerService.getListPT(studioId);

        int size = listPT.size() % 3 == 0 ? listPT.size() / 3 : (listPT.size() / 3 + 1);
        List<TrainerDTO> value = null;
        for (int i = 0; i < size; i++) {
            value = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if (i * 3 + j < listPT.size()) {
                    value.add(listPT.get(i * 3 + j));
                }
            }
            trainerMapList.put("PT-" + (i + 1), value);
        }
        model.addAttribute("studiolist", studioService.getAllStudio());
        model.addAttribute("studioName", studioId);
        model.addAttribute("list", trainerMapList);
        model.addAttribute("size", trainerMapList.size());
        return "testlistPT";
    }

    @RequestMapping(value = "/management/enableuser/{email}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String enableUser(@PathVariable("email") String email) {
        try {
            userService.enableById(email);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return "redirect:/user/management/listusers";
    }

    @RequestMapping(value = "/management/disableuser/{email}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String disableUser(@PathVariable("email") String email) {
        try {
            userService.disableUser(email);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return "redirect:/user/management/listusers";
    }

    @RequestMapping("/management/updateuser/{email}")
    public String getInformationUser(@PathVariable("email") String email, Model model) {
        List<Role> roleList = roleService.getRoleAdmin();
//        List<Studio> studioList = studioService.getAllStudios();
        UserDTO userDTO = userService.getUserByEmail(email);

        model.addAttribute("user", userDTO);
        model.addAttribute("listRole", roleList);
//        model.addAttribute("listStudio", studioList);
        return "management/UserManagement/UserUpdate";
    }

    @PostMapping("/management/updateuser/{email}")
    public String userUpdate(@PathVariable("email") String email, @ModelAttribute("user") UserDTO userDTO) {
        try {
            userService.update(userDTO);
            System.out.println(userDTO);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return "redirect:/user/management/listusers";


    }


    @RequestMapping("/management/avataruser/{email}")
    public String getInformationUserAvatar(@PathVariable("email") String email, Model model) {
        UserDTO userDTO = userService.getUserByEmail(email);
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
        UserDTO userDTO = userService.getUserByEmail(email);
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

    //Change Password
    @GetMapping("/profilechangepassword")
    public String changePassword(@AuthenticationPrincipal UserDetail userDetail, Model model) {
        model.addAttribute("user", userDetail.getUser());
        return "user/changepassword";
    }

    @PostMapping("/changepassword")
    public String passwordUpdate(@RequestParam("cPassword") String cpassword, @RequestParam("nPassword") String npassword, @RequestParam("cnPassword") String cnpassword, @AuthenticationPrincipal UserDetail userDetail, Model model, RedirectAttributes ra) {
        String path = "redirect:/user/profilechangepassword";
        try {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(cpassword,userDetail.getPassword()) && npassword.equals(cnpassword)) {
                ra.addFlashAttribute("success", "Change your password successfully! Please login again!");
                userDetail.getUser().setPassword(npassword);
                userService.updateUserPassword(userDetail.getUser());
                System.out.println("Password details: " + userDetail.getPassword() + "Password3: " + userDetail.getUser().getPassword() + "Current: " + cnpassword + "New: " + npassword + "Confirm New" + cnpassword);
                path = "redirect:/logout";
            } else if (!passwordEncoder.matches(cpassword,userDetail.getPassword())) {
                ra.addFlashAttribute("fail", "Current password is wrong! Please enter your password again!");
                model.addAttribute("nPassword", npassword);
                model.addAttribute("cnPassword", cnpassword);
                model.addAttribute("cPassword", cpassword);
                System.out.println("Password details: " + userDetail.getPassword() + "Password3: " + userDetail.getUser().getPassword() + "Current: " + cnpassword + "New: " + npassword + "Confirm New" + cnpassword);

            } else {
                ra.addFlashAttribute("fail", "Confirm new password must be different from new password! Please enter confirm new password again!");
                model.addAttribute("nPassword", npassword);
                model.addAttribute("cnPassword", cnpassword);
                model.addAttribute("cPassword", cpassword);
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
    public String resetPassGetOtp(@ModelAttribute("userDTO") User user, Model model, RedirectAttributes attributes) throws MessagingException, UnsupportedEncodingException {
        //validate email not exist
        List<Object> userPresentObj = userService.isUserPresent(user);
        if ((Boolean) userPresentObj.get(0)) {
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
    public String resetPassword(@ModelAttribute("userDTO") User user, @RequestParam String repassword, @RequestParam String password, Model model) {
        String path = "reset_password";
        if (password.equals(repassword) && password.length() >= 6) {
            userService.resetPassword(user.getEmail(), password);
            model.addAttribute("message", "Password reset successful");
            path = "reset_password";
        }
        if (!password.equals(repassword)) {
            model.addAttribute("invalid", "Password not matches ");
            path = "changepass";
        } else if (password.length() < 6 || repassword.length() < 6) {
            model.addAttribute("invalid", "Password must have length > 6");
            path = "changepass";
        }
        return path;
    }

    @GetMapping("/profile")
    public String myProfile(@AuthenticationPrincipal UserDetail userDetail, Model model) {
        model.addAttribute("registrations", registrationService.getRegistrationsByUserEmail(userDetail.getUser().getEmail()));
        model.addAttribute("user", userDetail.getUser());
        return "user/profile";
    }


}








