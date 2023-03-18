package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.dto.PackageDTO;
import fivemonkey.com.fitnessbackend.dto.ServiceTypeDTO;
import fivemonkey.com.fitnessbackend.dto.StudioDTO;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.services.CityService;
import fivemonkey.com.fitnessbackend.services.ServiceTypeService;
import fivemonkey.com.fitnessbackend.services.StudioService;
import fivemonkey.com.fitnessbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private ServiceTypeService serviceTypeService;
    @Autowired
    private CityService cityService;

    @Autowired
    UserService userService;
    @Autowired
    StudioService studioService;

    @GetMapping("/")
    public String getAllServiceType(@AuthenticationPrincipal UserDetail userDetail, Model model) {
        if(userDetail==null){
            return "/index";
        }
        String path = "redirect:/dashboard";
        User currentUser = userDetail.getUser();
        if ("ROLE0004".equalsIgnoreCase(currentUser.getRole().getId())
                || "ROLE0005".equalsIgnoreCase(currentUser.getRole().getId())) {
            List<ServiceTypeDTO> listServiceType = serviceTypeService.getAll();
            model.addAttribute("listServiceType", listServiceType);
            path = "/index";
        }
        //return "fragments/home_program";
        return path;
    }

    @GetMapping("/blog-writer")
    public String blogWriter() {
        return "/blog_writer";
    }

    @GetMapping("/register")
    public String register() {
        return "/register";
    }

    @GetMapping("/reset-password")
    public String resetPassword() {
        return "/reset_password";
    }

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal UserDetail userDetail) {
        return "/management/Dashboard/index";

    }

    @GetMapping("/managestudio")
    public String studioAdmin() {
        return "management/StudioManagement/manage_studio";
    }

    @GetMapping("/homepage/service")
    public String service(Model model) {
        long resultStudio=studioService.countStudio();
        List<ServiceTypeDTO> listServiceType = serviceTypeService.getAll();
        String role="ROLE0004";
        //count trainer
        long result=userService.countTrainer(role);
        model.addAttribute("numOfTrainer",result);
        model.addAttribute("numStudio", resultStudio);
        model.addAttribute("listServiceType", listServiceType);
        return "/program";
    }

    @RequestMapping(value = "/homepage/studio", method = {RequestMethod.GET, RequestMethod.POST})
    public String listStudiosHomepage(Model model,@RequestParam(value = "cityname", required = false, defaultValue = "All") String cityname) {
        Map<String, List<StudioDTO>> studioMapList = new HashMap<>();
        List<CityDTO> listCity = cityService.getAllCity();
        List<StudioDTO> studioList;
        if ( "All".equals(cityname)) {
            studioList =studioService.getAll();
        }else{
            studioList=studioService.getAllByCity(cityname);
        }
        for (int i = 0; i < (studioList.size() / 3) + 1; i++) {
            List<StudioDTO> value = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if (i * 3 + j < studioList.size()) {
                    value.add(studioList.get(i * 3 + j));
                }
            }
            studioMapList.put("STU-" + (i + 1), value);
        }
        model.addAttribute("cities", listCity);
        model.addAttribute("currentCity", cityname);
        model.addAttribute("studios", studioMapList);
        return "/studio";
    }
}
