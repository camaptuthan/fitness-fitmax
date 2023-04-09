package fivemonkey.com.fitnessbackend.controller;
import fivemonkey.com.fitnessbackend.configuration.Utility;
import fivemonkey.com.fitnessbackend.dto.*;
import fivemonkey.com.fitnessbackend.entities.*;
import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.configuration.ImageUploader;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.MailException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    HistoryService historyService;
    @Autowired
    private ImageUploader imageUploader;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private TrainerService trainerService;
    @Autowired
    private TraineeService traineeService;
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private ServicesService servicesService;
    @Autowired
    private AddressService addressService;

    @Autowired
    private CityService cityService;

    @Autowired
    private DistrictService districtService;

    @GetMapping("/management/listusers")
    public String listUser(Model model, @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword
            , @RequestParam(value = "cityName", required = false, defaultValue = "All") String cityName
            , @RequestParam(value = "roleId", required = false, defaultValue = "All") String roleId
            , @RequestParam(value = "studioId", required = false, defaultValue = "All") String studioId
            , @AuthenticationPrincipal UserDetail userDetail) {
        switch (userDetail.getUser().getRole().getId()) {

            case "ROLE01":
                model.addAttribute("listCity", addressService.getCities());
                model.addAttribute("listStudio", addressService.getStudioByCity(cityName));
                model.addAttribute("listRole", roleService.getRoleAdmin());
                model.addAttribute("list", userService.getUserByFieldsByAdmin(keyword, cityName, roleId, studioId));
                model.addAttribute("size", userService.getUserByFieldsByAdmin(keyword, cityName, roleId, studioId).size());
                break;
            case "ROLE02":
                List<UserDTO> userDTOList = userService.listUserByManage(userDetail.getUser().getStudio().getId(), keyword, roleId);
                model.addAttribute("listRole", roleService.getRoleManager());
                model.addAttribute("list", userDTOList);
                model.addAttribute("size", userDTOList == null ? 0 : userDTOList.size());
                break;
            case "ROLE04":
                List<UserDTO> userDTOList1 = userService.listUserByAssistant(userDetail.getUser().getStudio().getId(), keyword, roleId);
                model.addAttribute("listRole", roleService.getRoleAssistant());
                model.addAttribute("list", userDTOList1);
                model.addAttribute("size", userDTOList1 == null ? 0 : userDTOList1.size());
                break;
        }
        model.addAttribute("currentStudio", studioId);
        model.addAttribute("currentKeyword", keyword);
        model.addAttribute("currentCity", cityName);
        model.addAttribute("currentRole", roleId);
        return "management/UserManagement/UserList";
    }


    @GetMapping("/management/listuserchangest")
    public String listTraineeSwitch(@AuthenticationPrincipal UserDetail userDetail, Model model){
        switch (userDetail.getUser().getRole().getId()) {
            case "ROLE01":
//                model.addAttribute("list", traineeService.getTraineeSwByAdmin());
                break;

            case "ROLE02":
//                model.addAttribute("list", traineeService.getTraineeSw(userDetail.getUser().getCity().getName()));
                break;

        }

        return "management/UserManagement/ListUserST";
    }


    @RequestMapping( value = "/management/listuserchangest/accept/{email}",  method = {RequestMethod.PUT, RequestMethod.GET})
    public String acceptUserChangeSt(@PathVariable("email") String email){
        TraineeDTO traineeDTO = traineeService.getTraineeByEmail(email);
        traineeService.acceptSwichSt(traineeDTO);

        return "redirect:/user/management/listuserchangest";
    }
    @RequestMapping( value = "/management/listuserchangest/reject/{email}",  method = {RequestMethod.PUT, RequestMethod.GET})
    public String rejectUserChangeSt(@PathVariable("email") String email){
        TraineeDTO traineeDTO = traineeService.getTraineeByEmail(email);
        traineeService.rejectSwichSt(traineeDTO);

        return "redirect:/user/management/listuserchangest";
    }

    @RequestMapping(value = "/listpt", method = {RequestMethod.GET, RequestMethod.POST})
    public String getPT(Model model, @RequestParam(value = "studioId", required = false, defaultValue = "All") String studioId
            , @RequestParam(value = "cityName", required = false, defaultValue = "All") String cityName) {

        Map<String, List<TrainerDTO>> trainerMapList = new HashMap<>();
        List<TrainerDTO> listPT = null;
        if (("All").equals(cityName)) {
            listPT = trainerService.listAllPT();
        } else if (("All").equals(studioId)) {
            listPT = trainerService.getListPTByCity(cityName);
        } else {
            listPT = trainerService.getListPT(studioId);
        }

        int size = listPT.size() % 4 == 0 ? listPT.size() / 4 : (listPT.size() / 4 + 1);
        List<TrainerDTO> value = null;
        for (int i = 0; i < size; i++) {
            value = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                if (i * 4 + j < listPT.size()) {
                    value.add(listPT.get(i * 4 + j));
                }
            }
            trainerMapList.put("PT-" + (i + 1), value);
        }
        model.addAttribute("currentStudio", studioId);
        model.addAttribute("currentCity", cityName);
        model.addAttribute("listCity", cityService.getStudiosCity());
        model.addAttribute("listStudio", addressService.getStudioByCity(cityName));


        model.addAttribute("list", trainerMapList);
        model.addAttribute("size", trainerMapList.size());
        return "listPT";
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

    @RequestMapping("management/updateuser/{email}")
    public String getInformationUser(@PathVariable("email") String email, Model model) {
        List<Role> roleList = roleService.getRoleAdmin();
        UserDTO userDTO = userService.getUserByEmail(email);

        model.addAttribute("user", userDTO);
        model.addAttribute("listRole", roleList);
        return "management/UserManagement/UserUpdate";
    }

    @PostMapping("/updateuser/{email}")
    public String userUpdate(@PathVariable("email") String email, @ModelAttribute("user") UserDTO userDTO) {
        try {
            userService.update(userDTO);
            System.out.println(userDTO);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return "redirect:/user/management/listusers";


    }

    @GetMapping(value = "/history" )
    public String getHistorySwitch(@AuthenticationPrincipal UserDetail userDetail, Model model) {
//       List<HistoryDTO> history = historyService.getHistoryByTrainee(userDetail.getUser().getEmail());
//        model.addAttribute("history", history);
        return "user/history";
    }


    @RequestMapping("/avataruser/{email}")
    public String getInformationUserAvatar(@PathVariable("email") String email, Model model) {
        UserDTO userDTO = userService.getUserByEmail(email);
        model.addAttribute("user", userDTO);
        return "myprofile";
    }

    @PostMapping("/avataruser/{email}")
    public String userUpdate(@RequestParam("fileImage") MultipartFile multipartFile,

                             @ModelAttribute("user") UserDTO userDTO,
                             Model model) throws IOException {
        userService.saveThumbnail(imageUploader.upload(multipartFile), userDTO.getEmail());


        return "redirect:/user/updateprofile";
    }



    @RequestMapping("/ptdetail/{email}")
    public String getInformationPtDetail(@AuthenticationPrincipal UserDetail userDetail,
                                         @PathVariable("email") String email, Model model) {
        TrainerDTO trainerDTO = trainerService.getTrainerByEmail(email);


        boolean hasRegistered = false;
        if (userDetail != null) {
            hasRegistered = registrationService.hasRegistrationPt(email, userDetail.getUser().getEmail());
            model.addAttribute("userEmail", userDetail.getUser().getEmail());
            model.addAttribute("userPhone", userDetail.getUser().getPhone());
            model.addAttribute("userRole", userDetail.getUser().getRole().getId());
        } else {
            model.addAttribute("userEmail", "");
            model.addAttribute("userPhone", "");
        }
//        model.addAttribute("userRole", userDetail.getUser().getRole().getId());
        model.addAttribute("listservice", servicesService.getServicesPT());
        model.addAttribute("hasRegistered", hasRegistered);
        model.addAttribute("trainer", trainerDTO);

        return "ptDetails";
    }
    @PostMapping("/ptdetail/{email}")
    public String sendRequestBookPt(@AuthenticationPrincipal UserDetail userDetail,
                                    @RequestParam("servicePt") String serviceId,
                                    @PathVariable("email") String email, Model model){
        TrainerDTO trainerDTO = trainerService.getTrainerByEmail(email);
        registrationService.doRegistrationPt(email,userDetail.getUser(),serviceId);
        trainerService.setStatusTrainer(email);
        model.addAttribute("trainer", trainerDTO);
        return "redirect:/";


    }
    @RequestMapping("/changestudio")
    public String getStudioTrainee(@AuthenticationPrincipal UserDetail userDetail,
                                   @RequestParam(value = "city", required = false, defaultValue = "") String city,
                                   @RequestParam(value = "studioId", required = false, defaultValue = "All") String studioId,
                                   Model model){
        TraineeDTO traineeDTO = traineeService.getTraineeByEmail(userDetail.getUser().getEmail());
        model.addAttribute("listCity", cityService.getStudioCity(userDetail.getUser().getCity().getName()));
        model.addAttribute("regis", registrationService.getListRegistrationByUser(userDetail.getUser().getEmail()));
        model.addAttribute("listStudio", studioService.getAllStudio());
        model.addAttribute("trainee", traineeDTO);
        return "user/changeStudio";

    }

    @PostMapping("/changestudio/{email}")
    public String changeStuTrainee(@ModelAttribute("trainee") TraineeDTO traineeDTO,
                                   @RequestParam(value = "cityName", required = false, defaultValue = "") String city,
                                   @RequestParam(value = "studioId", required = false, defaultValue = "All") String studioId,
                                   @RequestParam(value = "serviceName", required = false, defaultValue = "") String serviceId,
                                   @RequestParam(value = "serviceOld", required = false, defaultValue = "") String serviceOld,
                                   Model model){
       traineeService.changeStatusChangeSt(traineeDTO.getEmail(),city,studioId,serviceId,serviceOld);

        model.addAttribute("trainee", traineeDTO);
        return "redirect:/";

    }

    @RequestMapping("/updateprofile")
    public String getInformationUserPro5(@AuthenticationPrincipal UserDetail userDetail, Model model) {
        UserDTO userDTO = userService.getUserByEmail(userDetail.getUser().getEmail());
        model.addAttribute("user", userDTO);
        return "myprofile";
    }



    @PostMapping("/updateprofile/{email}")
    public String userUpdateAll(@ModelAttribute("user") UserDTO userDTO, Model model) throws IOException {
        userService.updateUser(userDTO);
        return "redirect:/user/updateprofile";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("userDTO") User user, RedirectAttributes attributes, HttpServletRequest request, BindingResult bindingResult,Model model) throws MessagingException, UnsupportedEncodingException {
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

        try{
            userService.sendVerificationEmail(user, siteUrl);
        }catch (Exception e){
            model.addAttribute("errorMessage", e);
            return  "error-email";
        }
        userService.registerUser(user);
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
            if (passwordEncoder.matches(cpassword, userDetail.getPassword()) && npassword.equals(cnpassword)) {
                ra.addFlashAttribute("successchange", "Change your password successfully! Please login again!");
                userDetail.getUser().setPassword(npassword);
                userService.updateUserPassword(userDetail.getUser());
                path = "redirect:/logout";
            } else if (!passwordEncoder.matches(cpassword, userDetail.getPassword())) {
                ra.addFlashAttribute("fail", "Current password is wrong! Please enter your password again!");
                model.addAttribute("nPassword", npassword);
                model.addAttribute("cnPassword", cnpassword);
                model.addAttribute("cPassword", cpassword);
            } else if(!npassword.equals(cnpassword)) {
                ra.addFlashAttribute("fail", "Confirm new password must be different from new password! Please enter confirm new password again!");
                model.addAttribute("nPassword", npassword);
                model.addAttribute("cnPassword", cnpassword);
                model.addAttribute("cPassword", cpassword);
            }
            else ra.addFlashAttribute("fail", "New password must be at least 6 characters! Please enter New password again!");
            model.addAttribute("nPassword", npassword);
            model.addAttribute("cnPassword", cnpassword);
            model.addAttribute("cPassword", cpassword);
        } catch (Exception e) {
            e.printStackTrace();
            ra.addFlashAttribute("fail", "Fail");
        }
        return path;
    }

    @PostMapping("/reset-password")
    public String resetPassGetOtp(@ModelAttribute("userDTO") User user, Model model, RedirectAttributes attributes) throws MessagingException, UnsupportedEncodingException {
        //validate email not exist
        List<Object> userPresentObj = userService.isUserPresent(user);
        try{
            if ((Boolean) userPresentObj.get(0)) {
                userService.sendOTP(user.getEmail());
                model.addAttribute("email", user.getEmail());
                return "verifyOTP";
            }
        }catch (Exception e){
            attributes.addFlashAttribute("errorMessage", e);
            return  "error-email";
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
            model.addAttribute("email", email);
            return "verifyOTP";
        }
    }

    @PostMapping("/reset-password-result")
    public String resetPassword(@ModelAttribute("userDTO") User user,  @RequestParam String password, Model model) {
        String path = "verify_status";
        userService.resetPassword(user.getEmail(), password);
        model.addAttribute("title", "Password reset successfully please login .");
        return path;
    }

    @GetMapping("/myregistrations")
    public String myRegistrations(@AuthenticationPrincipal UserDetail userDetail, Model model) {
        model.addAttribute("registrations", registrationService.getRegistrationsByUserEmail(userDetail.getUser().getEmail()));
        return "user/registration";
    }

}








