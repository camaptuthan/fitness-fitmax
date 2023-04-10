package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.configuration.ImageUploader;
import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.CategoryDTO;
import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.dto.ServicesDTO;
import fivemonkey.com.fitnessbackend.dto.StudioDTO;
import fivemonkey.com.fitnessbackend.entities.City;
import fivemonkey.com.fitnessbackend.entities.District;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Controller
@RequestMapping("/studio")
public class StudioController {

    @Autowired
    private StudioService studioService;
    @Autowired
    private ImageUploader imageUploader;
    @Autowired
    private UserService userService;

    @Autowired
    private CityService cityService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    ServicesService servicesService;

    @Autowired
    private ModelMapperConfiguration<StudioDTO, Studio> modelMapper;

//    list studio in homepage
@GetMapping("/studio-details/{id}")
public String homepageStudioDetail(@PathVariable("id") String id, Model model, @RequestParam(value = "category", required = false, defaultValue = "0") Long category,
                                   @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                                   @RequestParam(value = "type", required = false, defaultValue = "All") String type) {
    StudioDTO s = studioService.getStudioDTOById(id);
    User u = userService.getManagerOfStudio(id);
    List<CategoryDTO> listCategory = categoryService.getAllCategoriesByType("service");
    Map<String, List<ServicesDTO>> packagesMapList = new HashMap<>();
    List<ServicesDTO> servicesDTOList = new ArrayList<>();
    List<String> listType = servicesService.getAllServiceType();
    if ("All".equals(type)) {
        servicesDTOList.addAll(servicesService.getPackageInStudio(keyword, s.getDistrictCityId(), category));
        servicesDTOList.addAll(servicesService.getClassesInStudio(keyword, s.getDistrictCityId(), s.getId(), category));
        servicesDTOList.addAll(servicesService.getPTsInStudio(keyword, s.getDistrictCityId(), s.getId(), category));
    }
    if ("Packages".equals(type)) {
        servicesDTOList = servicesService.getPackageInStudio(keyword, s.getDistrictCityId(), category);
    }
    if ("Classes".equals(type)) {
        servicesDTOList = servicesService.getClassesInStudio(keyword, s.getDistrictCityId(), s.getId(), category);
    }
    if ("Personal Training".equals(type)) {
        servicesDTOList = servicesService.getPTsInStudio(keyword, s.getDistrictCityId(), s.getId(), category);
    }
    int size = servicesDTOList.size() % 3 == 0 ? servicesDTOList.size() / 3 : (servicesDTOList.size() / 3 + 1);
    List<ServicesDTO> value = null;
    for (int i = 0; i < size; i++) {
        value = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            if (i * 3 + j < servicesDTOList.size()) {
                value.add(servicesDTOList.get(i * 3 + j));
            }
        }
        packagesMapList.put("PKG-" + (i + 1), value);
    }
    model.addAttribute("listType", listType);
    model.addAttribute("studios", s);
    model.addAttribute("managerStudio", u);
    model.addAttribute("size", packagesMapList.size());
    model.addAttribute("categoryList", listCategory);
    model.addAttribute("listServiceOfStudio", packagesMapList);
    model.addAttribute("currentKeyword", keyword);
    model.addAttribute("currentType", type);
    model.addAttribute("currentCategory", category);
    return "/user/studio_details";
}

    @RequestMapping(value = "management/studios", method = {RequestMethod.GET, RequestMethod.POST})
    public String listStudios(@AuthenticationPrincipal UserDetail userDetail, Model model,
                              @RequestParam(value = "city", required = false, defaultValue = "") String city,
                              @RequestParam(value = "status", required = false, defaultValue = "") String status,
                              @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                              @RequestParam(name = "pageNumber", required = false, defaultValue = "1") String pageNumber) {
        int totalPage = studioService.getTotalAllStudiosByFilter(keyword,city, status);
        List<City> listCity = new ArrayList<>();
        if (userDetail.getUser().getRole().getName().equals("Admin")) {

        } else if (userDetail.getUser().getRole().getName().equals("Studio Manager")) {
            model.addAttribute("studio", studioService.getStudioByManagerId(userDetail.getUser().getStudio().getId()));
        }
        listCity = cityService.getStudioCity();
        List<StudioDTO> listStudio = studioService.getAllStudiosByFilter(keyword,city, status, Integer.parseInt(pageNumber) - 1);
        model.addAttribute("studios", listStudio);
        model.addAttribute("cityList", listCity);
        model.addAttribute("currentCity", city);
        model.addAttribute("status", status);
        model.addAttribute("keyword", keyword);
        model.addAttribute("currentKeyword", keyword);
        model.addAttribute("currentStatus", status);
        model.addAttribute("currentPage", Integer.parseInt(pageNumber));
        if (totalPage == 0) {
            model.addAttribute("totalPage", totalPage + 1);
        }else {
            model.addAttribute("totalPage",totalPage);
        }
        return "management/StudioManagement/studios";
    }

    //Add Studio
    @GetMapping("/management/addstudio")
    public String newStudio(@AuthenticationPrincipal UserDetail userDetail,
                            @RequestParam(value = "city", required = false, defaultValue = "") String city, Model model){

        Studio studio = new Studio();
        List<City> cityList = cityService.getNewCity();

        if(city!=null && !city.equals("")){
            List<District> districtList = districtService.getNewDistrict(city);
            model.addAttribute("districtList", districtList);
        }
        else {
            model.addAttribute("districtList", null);
        }
        model.addAttribute("cityList", cityList);
        model.addAttribute("studio", studio);
        return "./management/StudioManagement/add_studio";

    }
    //Update Studio Status
    @GetMapping("/management/statusstudios/{id}/{status}")
    public String updateStatus(@PathVariable String id, @PathVariable boolean status) {
        Studio studio = studioService.getStudioByStudioId(id);
        studio.setStatus(!status);
        studioService.saveStudio(studio);
        return "redirect:/studio/management/studios";
    }
    //Update Studio
    @GetMapping("management/studios/edit/{id}")
    public String editStudioForm(@PathVariable String id, Model model) {
        model.addAttribute("studioDTO", studioService.getStudioDTOByStudioId(id));
        return "management/StudioManagement/updatestudio";
    }

    //Update Studio Post
    @PostMapping("management/studioupdate")
    public String updateStudio(@ModelAttribute("studioDTO") StudioDTO studio,
                               Model model,@RequestParam("fileImage") MultipartFile multipartFile) {
        // get studio from database by id
        Studio existingStudio = studioService.getStudioByStudioId(studio.getId());
        existingStudio.setName(studio.getName());
        existingStudio.setContact(studio.getContact());
        existingStudio.setDes(studio.getDes());
        existingStudio.setStatus(studio.isStatus());

        //save updated studio object

        studioService.saveStudio(existingStudio);
        return "redirect:/studio/management/studios";
    }
    //Add Studio Post
    @PostMapping("/management/poststudio")
    public String saveStudio( @ModelAttribute("studio") StudioDTO studioDTO , Model model, @RequestParam(value = "city", required =false, defaultValue = "") String city,
                              @RequestParam(value = "", required =false, defaultValue = "") String district,
                              @RequestParam("fileImage") MultipartFile multipartFile) {
        Studio studio = new Studio();
        studio.setStatus(true);
        studio.setName(studioDTO.getName());
        studio.setContact(studioDTO.getContact());
        studio.setDes(studioDTO.getDes());
        studio.setDate(new Date());
        studio.setAddress(studioDTO.getAddress());
        studio.setImage(studioDTO.getImage());
        if (multipartFile.isEmpty()) {
            studio.setImage("https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_default.jpg?alt=media&token=d96f81d3-65fc-43ac-be80-b8c9b6f55951");
        } else {
            studio.setImage(imageUploader.upload(multipartFile));
        }

        //New District
        District district1 = districtService.getDistrictByDistrictId(studioDTO.getDistrictName());
        studio.setDistrict(district1);
        studioService.saveStudio(studio);
        return "redirect:/studio/management/studios";
    }

}
