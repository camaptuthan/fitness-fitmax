package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.*;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.entities.Status;
import fivemonkey.com.fitnessbackend.imageuploader.ImageUploader;
import fivemonkey.com.fitnessbackend.repository.ServicesRepository;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/service")
public class ServicesController {
    @Autowired
    private ImageUploader imageUploader;

    @Autowired
    private ServicesService servicesService;

    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private CityService cityService;

    @Autowired
    private ClassService classService;

    @Autowired
    private StudioService studioService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @Autowired
    private StatusService statusService;

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

    //view package detail(user)
    @GetMapping("/packages/package-detail/{id}")
    public String viewPackageDetail(@AuthenticationPrincipal UserDetail userDetail, @PathVariable(name = "id") String id, Model model) {
        ServicesDTO s = servicesService.getServiceById(id);
        List<ServicesDTO> listPKG = servicesService.getAllPackages();
        Map<String, List<ServicesDTO>> packagesMapList = new HashMap<>();
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
        boolean hasRegistered = false;
        if (userDetail != null) {
            hasRegistered = registrationService.hasRegistration(s.getId(), userDetail.getUser().getEmail());
            model.addAttribute("userEmail", userDetail.getUser().getEmail());
            model.addAttribute("userPhone", userDetail.getUser().getPhone());
        } else {
            model.addAttribute("userEmail", "");
            model.addAttribute("userPhone", "");
        }
        model.addAttribute("userRole", userDetail.getUser().getRole().getId());
        model.addAttribute("hasRegistered", hasRegistered);
        model.addAttribute("packages", packagesMapList);
        model.addAttribute("package", s);
        return "user/package-detail";
    }

    //view all classes(user)
    @RequestMapping(value = "/classes", method = {RequestMethod.GET, RequestMethod.POST})
    public String getAllClasses(Model model, @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                                @RequestParam(value = "city", required = false, defaultValue = "All") String cityname,
                                @RequestParam(value = "studio", required = false, defaultValue = "All") String studio,
                                @RequestParam(value = "category", required = false, defaultValue = "0") String category,
                                @RequestParam(value = "pageNumber", required = false, defaultValue = "1") String pageNumber) {
        int totalPage = classService.totalPageBy4Fields(keyword, cityname, studio, Long.parseLong(category));
        List<CityDTO> listCity = cityService.getAllCities();
        List<StudioDTO> listStudio = studioService.getAllStudiosByCity(cityname);
        List<CategoryDTO> listCategory = categoryService.getAllCategoriesByType("service");
        List<ClassDTO> listClass = classService.getClassesBy4Fields(keyword, cityname, studio, Long.parseLong(category), Integer.parseInt(pageNumber) - 1);
        model.addAttribute("classes", listClass);
        model.addAttribute("size", listClass.size());
        model.addAttribute("cityList", listCity);
        model.addAttribute("studioList", listStudio);
        model.addAttribute("categoryList", listCategory);
        model.addAttribute("currentCity", cityname);
        model.addAttribute("currentStudio", studio);
        model.addAttribute("currentKeyword", keyword);
        model.addAttribute("currentCategory", category);
        model.addAttribute("currentPage", Integer.parseInt(pageNumber));
        if (totalPage == 0) {
            model.addAttribute("totalPage", totalPage + 1);
        }else {
            model.addAttribute("totalPage",totalPage);
        }
        return "user/class";
    }

    //view all packages in dashboard
    @RequestMapping(value = "/management/packages", method = {RequestMethod.GET, RequestMethod.POST})
    public String getAllPackages(Model model, @AuthenticationPrincipal UserDetail userDetail,
                                 @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                                 @RequestParam(value = "city", required = false, defaultValue = "All") String cityname,
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
        List<Status> statusList = statusService.getStatusByPackage();
        model.addAttribute("packages", listPKG);
        model.addAttribute("size", listPKG.size());
        model.addAttribute("cityList", listCity);
        model.addAttribute("studioList", listStudio);
        model.addAttribute("categoryList", listCategory);
        model.addAttribute("currentCity", cityname);
        model.addAttribute("currentStudio", studio);
        model.addAttribute("currentKeyword", keyword);
        model.addAttribute("currentCategory", category);
        model.addAttribute("statusList", statusList);
        return "management/PackageManagement/package-list";
    }


    //add new package
    @GetMapping("/management/add-package")
    public String addPackage(Model model) {
        model.addAttribute("packagenew", new ServicesDTO());
        return "management/PackageManagement/package-add";
    }

    //save new package
    @PostMapping("/management/save-package")
    public String savePackage(@ModelAttribute("packagenew") ServicesDTO packagenew, BindingResult result, RedirectAttributes attributes) {
        try {
            if (result.hasErrors()) {
                attributes.addFlashAttribute("fail", "Add fail!");
                return "management/PackageManagement/package-add";
            } else {
                servicesService.addNewPackage(packagenew);
                attributes.addFlashAttribute("success", "Add successful!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            attributes.addFlashAttribute("fail", "Add fail!");
        }
        return "redirect:/service/management/packages";
    }

    //update package b1
    @GetMapping("/management/update-package/{id}")
    public String getDetail(@PathVariable("id") String id, @AuthenticationPrincipal UserDetail userDetail, Model model,
                            @RequestParam(value = "status_type_id", required = false) String status_type_id,
                            @RequestParam(value = "city", required = false) String cityname,
                            @RequestParam(value = "studio", required = false, defaultValue = "All") String studio,
                            @RequestParam(value = "category", required = false) String category) {
        ServicesDTO servicesDTO = servicesService.getPackageDTOById(id);
        status_type_id = servicesDTO.getStatus() + "";
        cityname = servicesDTO.getCityName();
        if (null != servicesDTO.getStudioId()) {
            studio = servicesDTO.getStudioId();
        } else studio.equals("All");
        category = servicesDTO.getCategoryId().toString();
        List<StudioDTO> listStudio = studioService.getAllStudiosByCity(cityname);
        List<CategoryDTO> listCategory = categoryService.getAllCategoriesByType("service");
        ServiceTypeDTO serviceTypeDTO = serviceTypeService.getServiceTypeById(1L);
        List<Status> statusList = statusService.getStatusByPackage();
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
        model.addAttribute("package", servicesDTO);
        model.addAttribute("user_role", userDetail.getUser().getRole().getId());
        model.addAttribute("servicetype", serviceTypeDTO);
        model.addAttribute("cityList", listCity);
        model.addAttribute("studioList", listStudio);
        model.addAttribute("categoryList", listCategory);
        model.addAttribute("currentStatus", servicesDTO.getStatus());
        model.addAttribute("currentCity", cityname);
        model.addAttribute("currentStudio", studio);
        model.addAttribute("currentCategory", category);
        model.addAttribute("statusList", statusList);
        return "management/PackageManagement/package-update";
    }

    //update package b2
    @PostMapping("/management/update-package/{id}")
    public String PackageUpdate(@PathVariable("id") String id, @AuthenticationPrincipal UserDetail userDetail,
                                @RequestParam(value = "status_type_id", required = false) String status_type_id,
                                @RequestParam(value = "city", required = false) String cityname,
                                @RequestParam(value = "studio", required = false) String studio,
                                @RequestParam(value = "category", required = false) String category,
                                @RequestParam("fileImage") MultipartFile multipartFile,
                                @ModelAttribute("package") ServicesDTO servicesDTO) {
        Services s = servicesService.getPackageById(id);

        switch (userDetail.getUser().getRole().getId()) {
            case "ROLE01":
                s.setId(servicesDTO.getId());
                s.setName(servicesDTO.getName());
                s.setDes(servicesDTO.getDes());
                s.setPrice(servicesDTO.getPrice());
                s.setDate(servicesDTO.getDate());


                s.setImage(imageUploader.upload(multipartFile));

                s.setStatus(Integer.parseInt(status_type_id));
                s.setCity(cityService.getCityByName(cityname));
                s.setStudio(studioService.getStudioById(studio));
                s.setCategory(categoryService.getCategoryById(Long.parseLong(category)));
                if (multipartFile.isEmpty()) {
                    s.setImage("https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_default.jpg?alt=media&token=d96f81d3-65fc-43ac-be80-b8c9b6f55951");
                } else {
                    s.setImage(imageUploader.upload(multipartFile));
                }
                servicesRepository.save(s);
                break;
            case "ROLE02":
                s.setId(servicesDTO.getId());
                s.setName(servicesDTO.getName());
                s.setDes(servicesDTO.getDes());
                s.setPrice(servicesDTO.getPrice());
                s.setDate(servicesDTO.getDate());
                if (s.getStudio() == null || s.getStudio().getId() != userDetail.getUser().getStudio().getId()) {
                    s.setStatus(1);
                }
                s.setCity(cityService.getCityByName(cityname));
                s.setStudio(studioService.getStudioById(studio));
                s.setCategory(categoryService.getCategoryById(Long.parseLong(category)));
                if (multipartFile.isEmpty()) {
                    s.setImage("https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_default.jpg?alt=media&token=d96f81d3-65fc-43ac-be80-b8c9b6f55951");
                } else {
                    s.setImage(imageUploader.upload(multipartFile));
                }
                servicesRepository.save(s);
                break;
            case "ROLE03":
                s.setId(servicesDTO.getId());
                s.setName(servicesDTO.getName());
                s.setDes(servicesDTO.getDes());
                s.setPrice(servicesDTO.getPrice());
                s.setDate(servicesDTO.getDate());
                if (s.getStudio().getId() != userDetail.getUser().getStudio().getId()) {
                    s.setStatus(1);
                }
                s.setCity(cityService.getCityByName(cityname));
                s.setStudio(studioService.getStudioById(studio));
                s.setCategory(categoryService.getCategoryById(Long.parseLong(category)));
                if (multipartFile.isEmpty()) {
                    s.setImage("https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/gym_package_default.jpg?alt=media&token=d96f81d3-65fc-43ac-be80-b8c9b6f55951");
                } else {
                    s.setImage(imageUploader.upload(multipartFile));
                }
                servicesRepository.save(s);
                break;
        }
        return "redirect:/service/management/packages";
    }

}
