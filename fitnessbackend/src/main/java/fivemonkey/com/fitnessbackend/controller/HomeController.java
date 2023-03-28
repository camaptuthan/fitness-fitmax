package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.*;
import fivemonkey.com.fitnessbackend.entities.Slider;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ServiceTypeService serviceTypeService;
    @Autowired
    private CityService cityService;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private UserService userService;
    @Autowired
    private StudioService studioService;
    @Autowired
    private SliderService sliderService;


    @GetMapping("/")
    public String getAllServiceType(Model model) {
        List<ServiceTypeDTO> listServiceType = serviceTypeService.getAll();
        List<Slider> sliderList=sliderService.getAllSlider();
        List<TrainerDTO> getRandomPT = trainerService.getRandomPT();
        model.addAttribute("listServiceType", listServiceType);
        model.addAttribute("listSlider",sliderList);
        model.addAttribute("listRandomPT",getRandomPT);
        return "index";
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
    public String getAvatarUserDashboard(@AuthenticationPrincipal UserDetail userDetail,Model model) {
        UserDTO userDTO = userService.getUserByEmail(userDetail.getUser().getEmail());
        model.addAttribute("user", userDTO);
        return "/management/Dashboard/index";

    }

    @GetMapping("/trainer/detail")
    public String homepageTrainer() {
        return "/trainer";
    }

    @GetMapping("/schedule")
    public String homepageSchedule() {
        return "/schedule";
    }

    @GetMapping("/managestudio")
    public String studioAdmin() {
        return "management/StudioManagement/manage_studio";
    }

    @GetMapping("/homepage/service")
    public String service(Model model) {
        long resultStudio = studioService.countStudio();
        List<ServiceTypeDTO> listServiceType = serviceTypeService.getAll();
        String role = "ROLE04";
        //count trainer
        long result = userService.countTrainer(role);
        model.addAttribute("numOfTrainer", result);
        model.addAttribute("numStudio", resultStudio);
        model.addAttribute("listServiceType", listServiceType);
        return "/program";
    }

    @RequestMapping(value = "/studio", method = {RequestMethod.GET, RequestMethod.POST})
    public String listStudiosHomepage(Model model, @RequestParam(value = "cityname", required = false, defaultValue = "All") String cityname,
                                      @RequestParam(value = "page",required = false,defaultValue = "1") String page) {
        int totalPage = studioService.getTotalPage(cityname);
        List<CityDTO> listCity = cityService.getAllCities();
        List<StudioDTO> studioList = studioService.getStudioByCity(cityname,Integer.parseInt(page) - 1);
        model.addAttribute("size", studioList.size());
        model.addAttribute("cities", listCity);
        model.addAttribute("currentCity", cityname);
        model.addAttribute("studios", studioList);
        model.addAttribute("currentPage", Integer.parseInt(page));
        if (totalPage == 0) {
            model.addAttribute("totalPage", totalPage + 1);
        }else {
            model.addAttribute("totalPage",totalPage);
        }
        return "/user/studio";
    }

}
