//package fivemonkey.com.fitnessbackend.controller;
//
//import fivemonkey.com.fitnessbackend.dto.CategoryDTO;
//import fivemonkey.com.fitnessbackend.dto.CityDTO;
//import fivemonkey.com.fitnessbackend.security.UserDetail;
//import fivemonkey.com.fitnessbackend.services.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import javax.validation.Valid;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/package")
//public class PackageController {
//
//    @Autowired
//    private PackageService packageServices;
//
//    @Autowired
//    private ServiceService serviceService;
//
//    @Autowired
//    private CategoryService categoryService;
//    @Autowired
//    private RegistrationService registrationService;
//
//    @Autowired
//    private CityService cityService;
//
//    //view all packages(user)
//    @RequestMapping(value = "/packages", method = {RequestMethod.GET, RequestMethod.POST})
//    public String getAllPackages(Model model, @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
//                                 @RequestParam(value = "cityname", required = false, defaultValue = "All") String cityname) {
//        List<CityDTO> listCity = cityService.getAllCity();
//        List<CategoryDTO> categoryList = categoryService.findAllCategoriesByType("service");
//        Map<String, List<PackageDTO>> packagesMapList = new HashMap<>();
//        List<PackageDTO> listPkg;
//        if ("".equals(keyword) && "All".equals(cityname)) {
//            listPkg = packageServices.getAll();
//        } else if ("".equals(keyword)) {
//            listPkg = packageServices.getAllPackagesByCity(cityname);
//        } else {
//            listPkg = packageServices.getAllPackagesByCityAndSearch(cityname, keyword);
//        }
//        for (int i = 0; i < (listPkg.size() / 3) + 1; i++) {
//            List<PackageDTO> value = new ArrayList<>();
//            for (int j = 0; j < 3; j++) {
//                if (i * 3 + j < listPkg.size()) {
//                    value.add(listPkg.get(i * 3 + j));
//                }
//            }
//            packagesMapList.put("PKG-" + (i + 1), value);
//        }
//        model.addAttribute("packages", packagesMapList);
//        model.addAttribute("cities", listCity);
//        model.addAttribute("currentCity", cityname);
//        model.addAttribute("size", packagesMapList.size());
//        model.addAttribute("categoryList", categoryList);
//        return "management/PackageManagement/package";
//    }
//
//    //view packages in dashboard
//    @RequestMapping(value = "/management/packages", method = {RequestMethod.GET, RequestMethod.POST})
//    public String getAllPackagesForManagement(Model model, @AuthenticationPrincipal UserDetail userDetail,
//                                              @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
//                                              @RequestParam(value = "cityname", required = false, defaultValue = "All") String cityname,
//                                              @RequestParam(value = "studio",required = false, defaultValue = "All") String studio,
//                                              @RequestParam(value = "category", required = false, defaultValue = "") String category) {
//        List<CategoryDTO> categoryList = categoryService.findAllCategoriesByType("service");
//        List<CityDTO> listCity = new ArrayList<>();
//        List<PackageDTO> listPackage;
//        switch (userDetail.getUser().getRole().getId()) {
//            case "ROLE0001":
//                listCity = cityService.getAllCity();
//                if("".equals(keyword) && "All".equals(cityname)){
//                    listPackage = packageServices.getAll();
//                } else if ("".equals(keyword)) {
//                    listPackage = packageServices.getAllPackagesByCity(cityname);
//                } else {
//                    listPackage = packageServices.getAllPackagesByCityAndSearch(cityname, keyword);
//                }
////            case "ROLE0006":
////                listCity.add(cityService.getCityByCityManager(userDetail.getUser().getEmail()));
////                if ("".equals(keyword)){
////                    listPackage = packageServices.getAllPackagesByCity(cityService.getCityByCityManager(userDetail.getUser().getEmail()).getName());
////                }else {
////                    listPackage = packageServices.getAllPackagesByCityAndSearch(cityService.getCityByCityManager(userDetail.getUser().getEmail()).getName(), keyword);
////                }
////            case "ROLE0002":
////                listCity.add(cityService.getCityByAssistant(userDetail.getUser().getEmail()));
//
//
//        }
////        List<PackageDTO> list = packageServices.getAllPackageByStudio(userDetail.getUser().getEmail());
////        System.out.println(list);
//
//        return "management/PackageManagement/package-list";
//    }
//
//    //add new package
//    @GetMapping("/add-package")
//    public String addPackage(Model model) {
//        model.addAttribute("packagenew", new PackageDTO());
//        return "management/PackageManagement/package-add";
//    }
//
//    //save new package
//    @PostMapping("/save-package")
//    public String savePackage(@ModelAttribute("packagenew") @Valid PackageDTO packageDTO, BindingResult result, RedirectAttributes redirectAttributes) {
//
//        try {
//            if (result.hasErrors()) {
//                redirectAttributes.addFlashAttribute("fail", "Add fail!");
//                return "management/PackageManagement/package-add";
//            } else {
//                packageServices.save(packageDTO);
//                redirectAttributes.addFlashAttribute("success", "Add successful!");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            redirectAttributes.addFlashAttribute("fail", "Add fail!");
//        }
//        return "redirect:/package/packages";
//    }
//
//    //view package by id
//    @GetMapping("/package_detail/{id}")
//    public String viewPackageDetail(@AuthenticationPrincipal UserDetail userDetail, @PathVariable(name = "id") Long id, Model model) {
//        PackageDTO p = packageServices.getPackageById(id);
//        boolean hasRegistered = false;
//        if (userDetail != null) {
//            hasRegistered = registrationService.hasRegistration(p.getId().toString(), userDetail.getUser().getEmail());
//        }
//
//        model.addAttribute("hasRegistered", hasRegistered);
//        model.addAttribute("package", p);
//        return "management/PackageManagement/detail";
//    }
//
//    //disable package
//    @RequestMapping(value = "/disable-package/{id}", method = {RequestMethod.PUT, RequestMethod.GET})
//    public String disablePackage(@AuthenticationPrincipal UserDetail userDetail, @PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
//        try {
//            packageServices.disablePackageById(id);
//            redirectAttributes.addFlashAttribute("success", "Disabled");
//        } catch (Exception e) {
//            e.printStackTrace();
//            redirectAttributes.addFlashAttribute("fail", "Fail to disable");
//        }
//        return "redirect:/package/packages";
//    }
//
//    //enable package
//    @RequestMapping(value = "/enable-package/{id}", method = {RequestMethod.PUT, RequestMethod.GET})
//    public String enablePackage(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
//        try {
//            packageServices.enablePackageById(id);
//            redirectAttributes.addFlashAttribute("success", "Enable");
//        } catch (Exception e) {
//            e.printStackTrace();
//            redirectAttributes.addFlashAttribute("fail", "Fail to enable");
//        }
//        return "redirect:/package/packages";
//    }
//
//    //get package detail
//    @GetMapping("/update-package/{id}")
//    public String getDetail(@PathVariable("id") Long id, Model model) {
//        PackageDTO packageDTO = packageServices.getPackageById(id);
//        model.addAttribute("package", packageDTO);
//        return "management/PackageManagement/package-edit";
//    }
//
//
//    //edit package
//    @PostMapping("/update-package/{id}")
//    public String processUpdate(@PathVariable("id") Long id, @ModelAttribute("package") @Valid PackageDTO packageDTO, BindingResult result
//            , RedirectAttributes redirectAttributes) {
//        try {
//            if (result.hasErrors()) {
//                redirectAttributes.addFlashAttribute("fail", "Fail");
//                return "management/PackageManagement/package-edit";
//            } else {
//                packageServices.update(packageDTO);
//                redirectAttributes.addFlashAttribute("success", "Update Successfully");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            redirectAttributes.addFlashAttribute("fail", "Fail");
//        }
//        return "redirect:/package/packages";
//    }
//
////    @GetMapping("/page/{pageNo}")
////    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
////        int pageSize = 5;
////        Page<Package> packages = packageServices.findPaginated(pageNo, pageSize);
////        List<Package> packageList = packages.getContent();
////        model.addAttribute("currentPage", pageNo);
////        model.addAttribute("totalPages", packages.getTotalPages());
////        model.addAttribute("packageList", packageList);
////        return "management/PackageManagement/package-list";
////    }
//}
