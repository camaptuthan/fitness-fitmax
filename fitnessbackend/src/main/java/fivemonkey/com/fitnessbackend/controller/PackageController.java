package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.*;
import fivemonkey.com.fitnessbackend.entities.Package;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/package")
public class PackageController {

    @Autowired
    private PackageService packageServices;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private CityService cityService;

    @Autowired
    ModelMapperConfiguration<Package, PackageDTO> modelMapper;

    @Autowired
    private StudioService studioService;

    @Autowired
    private AssistantService assistantService;

    //view all packages(user)
    @RequestMapping(value = "/packages", method = {RequestMethod.GET, RequestMethod.POST})
    public String getAllPackages(Model model, @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                                 @RequestParam(value = "cityname", required = false, defaultValue = "All") String cityname) {
        List<CityDTO> listCity = cityService.getAllCity();
        List<CategoryDTO> categoryList = categoryService.findAllCategoriesByType("service");
        Map<String, List<PackageDTO>> packagesMapList = new HashMap<>();
        List<PackageDTO> listPkg;
        if ("".equals(keyword) && "All".equals(cityname)) {
            listPkg = packageServices.getAll();
        } else if ("".equals(keyword)) {
            listPkg = packageServices.getAllPackagesByCity(cityname);
        } else if ("All".equals(cityname)) {
            listPkg = packageServices.getAllPackagesByKeyword(keyword);
        } else {
            listPkg = packageServices.getAllPackagesByCityAndSearch(cityname, keyword);
        }
        for (int i = 0; i < (listPkg.size() / 3) + 1; i++) {
            List<PackageDTO> value = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if (i * 3 + j < listPkg.size()) {
                    value.add(listPkg.get(i * 3 + j));
                }
            }
            packagesMapList.put("PKG-" + (i + 1), value);
        }
        model.addAttribute("packages", packagesMapList);
        model.addAttribute("cities", listCity);
        model.addAttribute("currentCity", cityname);
        model.addAttribute("currentKeyword", keyword);
        model.addAttribute("size", packagesMapList.size());
        model.addAttribute("categoryList", categoryList);
        return "user/package";
    }

    //view packages in dashboard
    @RequestMapping(value = "/management/packages", method = {RequestMethod.GET, RequestMethod.POST})
    public String getAllPackagesForManagement(Model model, @AuthenticationPrincipal UserDetail userDetail,
                                              @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                                              @RequestParam(value = "cityname", required = false, defaultValue = "All") String cityname,
                                              @RequestParam(value = "studio", required = false, defaultValue = "All") String studio,
                                              @RequestParam(value = "category", required = false, defaultValue = "All") String category) {
        List<CategoryDTO> categoryList = categoryService.findAllCategoriesByType("service");
        List<CityDTO> listCity = new ArrayList<>();
        List<StudioDTO> listStudio = new ArrayList<>();
        List<PackageDTO> listPackage = new ArrayList<>();
        switch (userDetail.getUser().getRole().getId()) {
            case "ROLE0001":
                listCity = cityService.getAllCity();
                listStudio = studioService.getAllByCity(cityname);
                List<Package> listPackage1 = packageServices.getByFields(keyword, cityname, studio, category);
                listPackage = modelMapper.mapList(listPackage1, PackageDTO.class);
                System.out.println("HAPH" + listPackage);
                break;
            case "ROLE0006":
                listCity.add(cityService.getCityByCityManager(userDetail.getUser().getEmail()));
                listStudio = studioService.getAllByCity(cityname);
                listPackage1 = packageServices.getByFields(keyword, cityname, studio, category);
                listPackage = modelMapper.mapList(listPackage1, PackageDTO.class);
                break;
            case "ROLE0002":
                listCity.add(cityService.getCityByStudioManager(userDetail.getUser().getEmail()));
                listStudio.add(studioService.getByStudioManager(userDetail.getUser().getEmail()));
                listPackage1 = packageServices.getByFields(keyword, cityname, studio, category);
                listPackage = modelMapper.mapList(listPackage1, PackageDTO.class);
                break;
            case "ROLE0003":
                listCity.add(cityService.getCityByAssistant(userDetail.getUser().getEmail()));
                listStudio.add(studioService.getStudioByStudioId(assistantService.getStudioIdByAssistant(userDetail.getUser().getEmail())));
                listPackage1 = packageServices.getByFields(keyword, cityname, studio, category);
                listPackage = modelMapper.mapList(listPackage1, PackageDTO.class);
                break;
        }
        model.addAttribute("packages", listPackage);
        model.addAttribute("size", listPackage.size());
        model.addAttribute("citylist", listCity);
        model.addAttribute("studios", listStudio);
        model.addAttribute("categories", categoryList);
        model.addAttribute("currentCity", cityname);
        model.addAttribute("currentKeyword", keyword);
        model.addAttribute("currentStudio", studio);
        model.addAttribute("currentCategory", category);
        return "management/PackageManagement/package-list";
    }

    //add new package
    @GetMapping("/add-package")
    public String addPackage(Model model) {
        model.addAttribute("packagenew", new PackageDTO());
        return "management/PackageManagement/package-add";
    }

    //save new package
    @PostMapping("/save-package")
    public String savePackage(@ModelAttribute("packagenew") @Valid PackageDTO packageDTO, BindingResult result, RedirectAttributes redirectAttributes) {

        try {
            if (result.hasErrors()) {
                redirectAttributes.addFlashAttribute("fail", "Add fail!");
                return "management/PackageManagement/package-add";
            } else {
                packageServices.save(packageDTO);
                redirectAttributes.addFlashAttribute("success", "Add successful!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("fail", "Add fail!");
        }
        return "redirect:/package/packages";
    }

    //view package by id
    @GetMapping("/package_detail/{id}")
    public String viewPackageDetail(@AuthenticationPrincipal UserDetail userDetail, @PathVariable(name = "id") String id, Model model) {
        PackageDTO p = packageServices.getPackageById(id);
        boolean hasRegistered = false;
        if (userDetail != null) {
            hasRegistered = registrationService.hasRegistration(p.getId(), userDetail.getUser().getEmail());
        }

        model.addAttribute("hasRegistered", hasRegistered);
        model.addAttribute("package", p);
        return "user/packagedetail";
    }

    //disable package
    @RequestMapping(value = "/disable-package/{id}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String disablePackage(@AuthenticationPrincipal UserDetail userDetail, @PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        try {
            packageServices.disablePackageById(id);
            redirectAttributes.addFlashAttribute("success", "Disabled");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("fail", "Fail to disable");
        }
        return "redirect:/package/packages";
    }

    //enable package
    @RequestMapping(value = "/enable-package/{id}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String enablePackage(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        try {
            packageServices.enablePackageById(id);
            redirectAttributes.addFlashAttribute("success", "Enable");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("fail", "Fail to enable");
        }
        return "redirect:/package/packages";
    }

    //get package detail
    @GetMapping("/update-package/{id}")
    public String getDetail(@PathVariable("id") String id, Model model) {
        PackageDTO packageDTO = packageServices.getPackageById(id);
        model.addAttribute("package", packageDTO);
        return "management/PackageManagement/package-edit";
    }


    //edit package
    @PostMapping("/update-package/{id}")
    public String processUpdate(@PathVariable("id") String id, @ModelAttribute("package") @Valid PackageDTO packageDTO, BindingResult result
            , RedirectAttributes redirectAttributes) {
        try {
            if (result.hasErrors()) {
                redirectAttributes.addFlashAttribute("fail", "Fail");
                return "management/PackageManagement/package-edit";
            } else {
                packageServices.update(packageDTO);
                redirectAttributes.addFlashAttribute("success", "Update Successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("fail", "Fail");
        }
        return "redirect:/package/packages";
    }



//    @GetMapping("/page/{pageNo}")
//    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
//        int pageSize = 5;
//        Page<Package> packages = packageServices.findPaginated(pageNo, pageSize);
//        List<Package> packageList = packages.getContent();
//        model.addAttribute("currentPage", pageNo);
//        model.addAttribute("totalPages", packages.getTotalPages());
//        model.addAttribute("packageList", packageList);
//        return "management/PackageManagement/package-list";
//    }
}
