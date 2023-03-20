package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.CategoryDTO;
import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.dto.ServicesDTO;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.service.service.CategoryService;
import fivemonkey.com.fitnessbackend.service.service.CityService;
import fivemonkey.com.fitnessbackend.service.service.ServicesService;
import fivemonkey.com.fitnessbackend.service.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    private ModelMapperConfiguration<Services, ServicesDTO> modelMapper;

    //view all packages(user)
    @RequestMapping(value = "/packages", method = {RequestMethod.GET, RequestMethod.POST})
    public String getAllPackages(Model model, @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                                 @RequestParam(value = "cityname", required = false, defaultValue = "All") String cityname,
                                 @RequestParam(value = "category", required = false, defaultValue = "All") String category) {
        List<CityDTO> listCity = cityService.getAllCities();
        List<CategoryDTO> listCategory = categoryService.getAllCategoriesByType("service");
        Map<String, List<ServicesDTO>> packagesMapList = new HashMap<>();
        List<Services> listPKG1 = servicesService.getPackagesBy3Fields(keyword, cityname, category);
        System.out.println("HAPH" + listPKG1);
        List<ServicesDTO> listPKG = modelMapper.mapList(listPKG1, ServicesDTO.class);
        for (int i = 0; i < (listPKG.size() / 3) + 1; i++) {
            List<ServicesDTO> value = new ArrayList<>();
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
}
