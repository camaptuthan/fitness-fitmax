package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.CategoryDTO;
import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.dto.DistrictDTO;
import fivemonkey.com.fitnessbackend.entities.Category;
import fivemonkey.com.fitnessbackend.entities.City;
import fivemonkey.com.fitnessbackend.repository.CategoryRepository;
import fivemonkey.com.fitnessbackend.repository.CityRepository;
import fivemonkey.com.fitnessbackend.repository.DistrictRepository;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.service.CategoryService;
import fivemonkey.com.fitnessbackend.service.CityService;
import fivemonkey.com.fitnessbackend.service.DistrictService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/setting")
public class SettingController {

    @Autowired
    private CityService cityService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/management/city")
    public String getAllCity(Model model, @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
                             @RequestParam(name = "page", required = false, defaultValue = "1") String pageNumber) {
        int totalPage = cityService.getTotalPageCity(keyword);
        List<CityDTO> listCity = cityService.getAllCityByKeyword(keyword, Integer.parseInt(pageNumber) - 1);
        model.addAttribute("listCity", listCity);
        model.addAttribute("currentPage", Integer.parseInt(pageNumber));
        model.addAttribute("currentKeyword", keyword);
        if (totalPage == 0) {
            model.addAttribute("totalPage", totalPage + 1);
        } else {
            model.addAttribute("totalPage", totalPage);
        }
        return "management/SettingManagement/city-list";
    }

    @GetMapping("/management/city/city-detail/{id}")
    public String getCityDetail(Model model, @PathVariable("id") Long id, @AuthenticationPrincipal UserDetail userDetail,
                                @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
                                @RequestParam(name = "page", required = false, defaultValue = "1") String pageNumber) {
        int totalPage = districtService.totalPageDistrictByCity(id, keyword);
        CityDTO cityDTO = cityService.getCityById(id);
        List<DistrictDTO> listDistrict = districtService.getDistrictByCity(id, keyword, Integer.parseInt(pageNumber) - 1);
        model.addAttribute("city", cityDTO);
        model.addAttribute("listDistrict", listDistrict);
        model.addAttribute("currentPage", Integer.parseInt(pageNumber));
        model.addAttribute("currentKeyword", keyword);
        if (totalPage == 0) {
            model.addAttribute("totalPage", totalPage + 1);
        } else {
            model.addAttribute("totalPage", totalPage);
        }
        return "management/SettingManagement/city-update";
    }

    @PostMapping("/management/city/city-detail/{id}")
    public String updateCity(@ModelAttribute("city") CityDTO cityDTO, @AuthenticationPrincipal UserDetail userDetail) {
        City city = cityService.getCityByCityId(cityDTO.getId());
        city.setName(cityDTO.getName());
        city.setType(cityDTO.getType());

        return "redirect:/city-list";
    }

    @GetMapping("/management/category")
    public String getAllCategory(Model model, @RequestParam(name = "type", required = false, defaultValue = "All") String type,
                                 @RequestParam(name = "page", required = false, defaultValue = "1") String pageNumber){
        int totalPage = categoryService.totalPageCategory(type);
        List<CategoryDTO> listCategory = categoryService.findCategoryBy2Fields(type, Integer.parseInt(pageNumber) - 1);
        List<String> listType = categoryService.getAllCategoryType();
        model.addAttribute("listCategory",listCategory);
        model.addAttribute("currentType", type);
        model.addAttribute("listType", listType);
        model.addAttribute("currentPage", Integer.parseInt(pageNumber));
        if (totalPage == 0) {
            model.addAttribute("totalPage", totalPage + 1);
        } else {
            model.addAttribute("totalPage", totalPage);
        }
        model.addAttribute("categoryDTO", new CategoryDTO());
        return "management/SettingManagement/category-list";
    }

    @PostMapping("/management/category/add-category")
    public String addCategory(@ModelAttribute("categoryDTO") CategoryDTO categoryDTO, @RequestParam(name = "type", required = false) String type){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setType(categoryDTO.getType());
        category.setDes(categoryDTO.getDes());
        categoryRepository.save(category);
        return "redirect:/setting/management/category";
    }
}
