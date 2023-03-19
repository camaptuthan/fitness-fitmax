package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.entities.Registration;
import fivemonkey.com.fitnessbackend.repository.RegistrationRepository;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private RegistrationRepository registrationRepository;

    @PostMapping("/make")
    public String doRegistration(@RequestParam("item_id") String itemId, @AuthenticationPrincipal UserDetail userDetail) {
//        registrationService.doRegistration(userDetail.getUser(), itemId);
        return "redirect:/user/profile";
    }

    //Get Registration List
    @GetMapping("management/registrations")
    public String listRegistration(@AuthenticationPrincipal UserDetail userDetail, Model model) {
        if (userDetail.getUser().getRole().getName().equals("Admin")) {
//            model.addAttribute("registrations", registrationService.getAllRegistrations());
        } else if (userDetail.getUser().getRole().getName().equals("Manager")) {
//            model.addAttribute("registrations", registrationService.getRegistrationByManager(userDetail.getUser().getStudioManager().getStudio().getId()));
//        } else if (userDetail.getUser().getRole().getName().equals("Assistant")) {
//            model.addAttribute("registrations", registrationService.getRegistrationByAssistant(userDetail.getUser().getEmail()));
//        }

            System.out.println("User role = " + userDetail.getUser().getRole().getName());

//        model.addAttribute("registraions", registrationService.getAllRegistrations());
//        model.addAttribute("userDetail", userDetail.getUser().getRole());
            return "management/RegistrationManagement/registration";
        }
        return null;
    }
//
//    @PostMapping("management/registrationpost/{id}")
//    public String updateStudio(@PathVariable String id,
//                               @ModelAttribute("registration") Registration registration,
//                               Model model) {
//        // get studio from database by id
//        Registration existingRegis = registrationService.getRegistrationById(id);
//        existingRegis.setId(id);
//        existingRegis.setStatus(registration.isStatus());
////        existingRegis.getDate();
////        existingRegis.setDes(registration.getDes());
////        existingRegis.setStatus(registration.isStatus());
//        // save updated studio object
//        registrationService.updateRegistration(existingRegis);
//        return "redirect:/studios";
//    }

//    @PostMapping("/postregistration")
//    public String saveStudio(@ModelAttribute("registration") Registration registration) {
//        registration.setStatus(true);
//        registrationRepository.save(registration);
//        return "redirect:/studios";
//    }
//
//    @GetMapping("/management/registrationsedit/{id}")
//    public String updateRegis(@PathVariable String id, Model model) {
//        model.addAttribute("registration", registrationService.getRegistrationById("SER0001"));
//        return "management/RegistrationManagement/registrationdetails";
//    }


}
