package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.dto.RegistrationDTO;
import fivemonkey.com.fitnessbackend.entities.Registration;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.repository.RegistrationRepository;
import fivemonkey.com.fitnessbackend.repository.StatusRepository;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.service.service.CityService;
import fivemonkey.com.fitnessbackend.service.service.RegistrationService;
import fivemonkey.com.fitnessbackend.service.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private StatusRepository statusRepository;
    @Autowired
    private StatusService statusService;

    @PostMapping("/make")
    public String doRegistration(@RequestParam("item_id") String serviceId, @AuthenticationPrincipal UserDetail userDetail) {
        String path = "redirect:/user/profile";
        if (userDetail == null) {
            path = "redirect:/login";
        }
        assert userDetail != null;

        registrationService.doRegistration(userDetail.getUser(), serviceId);
        return path;
    }



    //Get Registration List

    @GetMapping("management/registrationsd")
    public String listRegistration(@AuthenticationPrincipal UserDetail userDetail,
                                   @RequestParam(value ="keyword" , required = false, defaultValue = "") String keyword,
                                   @RequestParam(value ="city" ,required = false, defaultValue = "") String city,
                                   @RequestParam(value = "studio", required = false, defaultValue = "") String studio,
                                   @RequestParam(value ="studioStatus", required = false, defaultValue = "") String studioStatus,
                                   Model model) {
        List<CityDTO> listCity = new ArrayList<>();
        if (userDetail.getUser().getRole().getName().equals("Admin")) {
            listCity = cityService.getAllCities();
            model.addAttribute("registrations", registrationService.getAllRegistrations());
        } else if (userDetail.getUser().getRole().getName().equals("Manager")) {
            model.addAttribute("registrations", registrationService.getRegistrationByManager(userDetail.getUser().getStudio().getId()));
        } else if (userDetail.getUser().getRole().getName().equals("Assistant")) {
            model.addAttribute("registrations", registrationService.getRegistrationByAssistant(userDetail.getUser().getEmail()));
        }
        model.addAttribute("keyword", keyword);
        model.addAttribute("status", studioStatus);
        model.addAttribute("listCity", listCity);
        model.addAttribute("currentCity", city);
        model.addAttribute("statusList", statusService.getStatusByPackage());
        model.addAttribute("registrations", registrationService.getAllRegistrations());
        return "management/RegistrationManagement/registration";
    }

    //Get Registration List by Filter
    @GetMapping("/management/registrations")
    public String getRegistrationByFilter(@AuthenticationPrincipal UserDetail userDetail,
                                          @RequestParam(value ="keyword" , required = false, defaultValue = "") String keyword,
                                          @RequestParam(value ="city" ,required = false, defaultValue = "") String city,
                                          @RequestParam(value = "studio", required = false, defaultValue = "") String studio,
                                          @RequestParam(value ="studioStatus", required = false, defaultValue = "") String studioStatus,
                                          Model model) {
        List<CityDTO> listCity = new ArrayList<>();
        if (userDetail.getUser().getRole().getName().equals("Admin")) {
            //model.addAttribute("registrations", registrationService.getAllRegistrations());
            listCity = cityService.getAllCities();
        } else if (userDetail.getUser().getRole().getName().equals("Manager")) {
           //model.addAttribute("registrations", registrationService.getRegistrationByManager(userDetail.getUser().getStudio().getId()));
        } else if (userDetail.getUser().getRole().getName().equals("Assistant")) {
            //model.addAttribute("registrations", registrationService.getRegistrationByAssistant(userDetail.getUser().getEmail()));
        }
        List<RegistrationDTO> registrationDTOS = registrationService.getRegistrationByFilter(keyword, city, studio, studioStatus);
        model.addAttribute("registrations", registrationDTOS);

        model.addAttribute("keyword", keyword);
        model.addAttribute("status", studioStatus);
        model.addAttribute("listCity", listCity);
        model.addAttribute("currentCity", city);
        model.addAttribute("statusList", statusService.getStatusByPackage());
        return "management/RegistrationManagement/registration";
    }
    @PostMapping("management/registrationpost/{id}")
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
