package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.CategoryDTO;
import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.dto.ServicesDTO;
import fivemonkey.com.fitnessbackend.dto.StudioDTO;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.service.service.CategoryService;
import fivemonkey.com.fitnessbackend.service.service.CityService;
import fivemonkey.com.fitnessbackend.service.service.ServicesService;
import fivemonkey.com.fitnessbackend.service.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/service")
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    @Autowired
    private CityService cityService;

    @Autowired
    private StudioService studioService;

    @Autowired
    private CategoryService categoryService;


    //view all packages(user)
    @RequestMapping(value = "/packages", method = {RequestMethod.GET, RequestMethod.POST})
    public String getAllPackages(Model model, @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                                 @RequestParam(value = "city", required = false, defaultValue = "All") String cityname,
                                 @RequestParam(value = "category", required = false, defaultValue = "0") String category) {
        List<CityDTO> listCity = cityService.getAllCities();
        List<CategoryDTO> listCategory = categoryService.getAllCategoriesByType("service");
        Map<String, List<ServicesDTO>> packagesMapList = new HashMap<>();
        List<ServicesDTO> listPKG = servicesService.getPackagesBy3Fields(keyword, cityname, Long.parseLong(category));
        int size = listPKG.size() % 3 == 0 ? listPKG.size() / 3 : (listPKG.size() / 3 + 1);
        List<ServicesDTO> value = null;
        for (int i = 0; i < size; i++) {
            value = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if (i * 3 + j < listPKG.size()) {
                    value.add(listPKG.get(i * 3 + j));
                }
            }
            packagesMapList.put("PKG-" + (i + 1), value);
        }

        model.addAttribute("packages", packagesMapList);
        model.addAttribute("size", packagesMapList.size());
        model.addAttribute("cityList", listCity);
        model.addAttribute("categoryList", listCategory);
        model.addAttribute("currentCity", cityname);
        model.addAttribute("currentKeyword", keyword);
        model.addAttribute("currentCategory", category);
        return "user/package";
    }

    //view all packages in dashboard
    @RequestMapping(value = "management/packages", method = {RequestMethod.GET, RequestMethod.POST})
    public String getAllPackages(Model model, @AuthenticationPrincipal UserDetail userDetail,
                                 @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                                 @RequestParam(value = "cityname", required = false, defaultValue = "All") String cityname,
                                 @RequestParam(value = "studio", required = false, defaultValue = "All") String studio,
                                 @RequestParam(value = "category", required = false, defaultValue = "0") String category) {
        List<CityDTO> listCity = new ArrayList<>();
        switch (userDetail.getUser().getRole().getId()) {
            case "ROLE01":
                listCity = cityService.getAllCities();
                break;
            case "ROLE02":
                listCity.add(cityService.getCityByStudioManager(userDetail.getUser().getEmail()));
                break;
            case "ROLE03":
                listCity.add(cityService.getCityByAssistant(userDetail.getUser().getEmail()));
                break;
        }
        List<CategoryDTO> listCategory = categoryService.getAllCategoriesByType("service");
        List<StudioDTO> listStudio = studioService.getAllStudiosByCity(cityname);
        List<ServicesDTO> listPKG = servicesService.getPackagesBy4Fields(keyword, cityname, studio, Long.parseLong(category));
        model.addAttribute("packages", listPKG);
        model.addAttribute("size", listPKG.size());
        model.addAttribute("cityList", listCity);
        model.addAttribute("studioList",listStudio);
        model.addAttribute("categoryList", listCategory);
        model.addAttribute("currentCity", cityname);
        model.addAttribute("currentStudio", studio);
        model.addAttribute("currentKeyword", keyword);
        model.addAttribute("currentCategory", category);
        return "management/PackageManagement/package-list";
    }

    //view package detail
    @GetMapping("/packages/package-detail/{id}")
    public String viewPackageDetail(@AuthenticationPrincipal UserDetail userDetail, @PathVariable(name = "id") String id, Model model){
        ServicesDTO s = servicesService.getServiceById(id);
        model.addAttribute("package", s);
        return "user/package-detail";
    }
}
