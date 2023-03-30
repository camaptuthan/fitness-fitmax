package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.configuration.Utility;
import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.dto.RegistrationDTO;
import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.City;
import fivemonkey.com.fitnessbackend.entities.Registration;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.repository.RegistrationRepository;
import fivemonkey.com.fitnessbackend.repository.StatusRepository;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.service.service.CityService;
import fivemonkey.com.fitnessbackend.service.service.RegistrationService;
import fivemonkey.com.fitnessbackend.service.service.StatusService;
import fivemonkey.com.fitnessbackend.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private CityService cityService;

    @Autowired
    private UserService userService;

    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private StatusService statusService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/make")
    public String doRegistration(@AuthenticationPrincipal UserDetail userDetail,
                                 @RequestParam("id") String serviceId,
                                 @RequestParam("emailRegis") String email,
                                 @RequestParam("phoneRegis") String phone,
                                 HttpServletRequest request,
                                 Model model
    ) {
        String path="/verify_status";
        //truong hop login account verify register by input otp
        if(userDetail!=null){
            try {
                userService.sendOTP(email);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
            model.addAttribute("email", email);
            model.addAttribute("idP",serviceId);
            path= "verify_registration";
            //
        }else if(userDetail==null ){
            User u= userRepository.getUserByEmail(email);
            //user exist
            if(u!=null){
                model.addAttribute("title","Email enroll already exist in system, please login to enroll service");
                return "/verify_status";
            }
            User user = new User();
            user.setEmail(email);
            user.setPhone(phone);
            user.setPassword("123456");
            user.setStatus(false);
            userService.registerUser(user);
            String siteUrl = Utility.getSiteURL(request);
            try {
                userService.sendVerificationEmail(user, siteUrl);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }

            //Create new registration
            registrationService.doRegistration(user, serviceId);
            String message="Check email registed to active account and completed enroll and waiting result";
            model.addAttribute("title", message);
            path= "/verify_status";
        }
        return path;
    }

    @PostMapping("/enrolled")
    public String verifyEnrollByCode(@AuthenticationPrincipal UserDetail userDetail,
                                     @RequestParam("idP") String idP,
                                     @RequestParam("email") String email,
                                     @RequestParam String otp
                                    ,Model model ){
        if (userService.verifyOTP(email, otp)) {
            User u= userRepository.getUserByEmail(email);
            registrationService.doRegistration(u, idP);
            return "redirect:/user/myregistrations";
        } else {
            model.addAttribute("error", "Invalid OTP");
            return "verify_registration";
        }

    }


    //Get Registration List by Filter
    @GetMapping("/management/registrations")
    public String getRegistrationByFilter(@AuthenticationPrincipal UserDetail userDetail,
                                          @RequestParam(value ="keyword" , required = false, defaultValue = "") String keyword,
                                          @RequestParam(value ="city" ,required = false, defaultValue = "") String city,
                                          @RequestParam(value = "studio", required = false, defaultValue = "") String studio,
                                          @RequestParam(value ="studioStatus", required = false, defaultValue = "") String studioStatus,
                                          Model model) {
        List<City> listCity = new ArrayList<>();
        if (userDetail.getUser().getRole().getName().equals("Admin")) {
            //model.addAttribute("registrations", registrationService.getAllRegistrations());

        } else if (userDetail.getUser().getRole().getName().equals("Manager")) {
            //model.addAttribute("registrations", registrationService.getRegistrationByManager(userDetail.getUser().getStudio().getId()));
        } else if (userDetail.getUser().getRole().getName().equals("Assistant")) {
            //model.addAttribute("registrations", registrationService.getRegistrationByAssistant(userDetail.getUser().getEmail()));
        }
        listCity = cityService.getRegistrationCity();
        List<RegistrationDTO> registrationDTOS = registrationService.getRegistrationByFilter(keyword, city, studio, studioStatus);
        model.addAttribute("registrations", registrationDTOS);

        model.addAttribute("keyword", keyword);
        model.addAttribute("status", studioStatus);
        model.addAttribute("listCity", listCity);
        model.addAttribute("currentCity", city);
        model.addAttribute("statusList", statusService.getStatusByRegistration());
        return "management/RegistrationManagement/registration";
    }

    //Get Details Registration
    @GetMapping("/management/registrations/{id}")
    public String getRegistrationById(@PathVariable String id, Model model) {
        Registration registration = registrationService.getRegistrationById(id);
        model.addAttribute("registration", registration);
        model.addAttribute("statusList", statusService.getStatusByRegistration());

        return "management/RegistrationManagement/registrationdetails";
    }

    @PostMapping("management/registrationpost")
    public String updateStudio(@PathVariable String id,
                               @ModelAttribute("registration") Registration registration,
                               Model model) {
        // get studio from database by id
        Registration existingRegis = registrationService.getRegistrationById(id);
        existingRegis.setId(id);
        existingRegis.setStatus(registration.getStatus());
        // save updated studio object
        registrationService.updateRegistration(existingRegis);
        return "redirect:/studios";
    }

    @PostMapping("/postregistration")
    public String saveStudio(@ModelAttribute("registration") Registration registration) {
        registration.setStatus(0);
        registrationRepository.save(registration);
        return "redirect:/studios";
    }

    @GetMapping("/management/registrationsedit/{id}")
    public String updateRegis(@PathVariable String id, Model model) {
        model.addAttribute("registration", registrationService.getRegistrationById("SER0001"));
        return "management/RegistrationManagement/registrationdetails";
    }

    //Approve and reject Registration
    @GetMapping("/management/statusregistrations/{id}/{status}")
    public String updateStatus(@AuthenticationPrincipal UserDetail userDetail,@PathVariable String id, @PathVariable int status) {
        Registration registration = registrationService.getRegistrationById(id);
        registration.setStatus(status);
        registration.setApprovedBy(userDetail.getUser().getEmail());
        registrationService.updateRegistration(registration);
        return "redirect:/registration/management/registrations";
    }

}
