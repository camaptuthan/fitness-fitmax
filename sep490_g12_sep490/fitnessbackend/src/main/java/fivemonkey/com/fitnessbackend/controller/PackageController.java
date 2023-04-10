package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.PackageDTO;
import fivemonkey.com.fitnessbackend.entities.Package;
import fivemonkey.com.fitnessbackend.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/package")
public class PackageController {

    @Autowired
    private PackageService packageServices;

    //view all packages
    @GetMapping("/packages")
    public String getAllPackages(Model model) {
        return findPaginated(1, model);
    }

    //add new package
    @GetMapping("/add-package")
    public String addPackage(Model model) {
        model.addAttribute("packagenew", new PackageDTO());
        return "management/PackageManagement/package-add";
    }

    //save new package
    @PostMapping("/save-package")
    public String savePackage(@ModelAttribute("packagenew") @Valid PackageDTO packageDTO, BindingResult result, RedirectAttributes redirectAttributes){

        try{
            if(result.hasErrors()){
                redirectAttributes.addFlashAttribute("fail","Add fail!");
                return "management/PackageManagement/package-add";
            }else {
                packageServices.save(packageDTO);
                redirectAttributes.addFlashAttribute("success","Add successful!");
            }
        }catch (Exception e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("fail","Add fail!");
        }
        return "redirect:/package/packages";
    }

    //view package by id
    @GetMapping("/package_detail/{id}")
    public String viewPackageDetail(@PathVariable(name = "id") String id, Model model) {
        PackageDTO p = packageServices.getPackageById(id);
        model.addAttribute("package", p);
        return "management/PackageManagement/detail";
    }

    //disable package
    @RequestMapping(value="/disable-package/{id}",method = {RequestMethod.PUT,RequestMethod.GET})
    public String disablePackage(@PathVariable("id") String id,RedirectAttributes redirectAttributes){
        try{
            packageServices.disablePackageById(id);
            redirectAttributes.addFlashAttribute("success","Disabled");
        }catch (Exception e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("fail","Fail to disable");
        }
        return "redirect:/package/packages";
    }

    //enable package
    @RequestMapping(value="/enable-package/{id}",method = {RequestMethod.PUT,RequestMethod.GET})
    public String enablePackage(@PathVariable("id") String id,RedirectAttributes redirectAttributes){
        try{
            packageServices.enablePackageById(id);
            redirectAttributes.addFlashAttribute("success","Enable");
        }catch (Exception e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("fail","Fail to enable");
        }
        return "redirect:/package/packages";
    }

    //get package detail
    @GetMapping("/update-package/{id}")
    public String getDetail(@PathVariable("id") String id,Model model){
        PackageDTO packageDTO=packageServices.getPackageById(id);
        model.addAttribute("package",packageDTO);
        return "management/PackageManagement/package-edit";
    }


    //edit package
    @PostMapping("/update-package/{id}")
    public String processUpdate(@PathVariable("id") String id, @ModelAttribute("package") @Valid PackageDTO packageDTO, BindingResult result
            ,RedirectAttributes redirectAttributes){
        try{
            if(result.hasErrors()){
                redirectAttributes.addFlashAttribute("fail","Fail");
                return "management/PackageManagement/package-edit";
            }
            else{
                packageServices.update(packageDTO);
                redirectAttributes.addFlashAttribute("success","Update Successfully");
            }
        }catch (Exception e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("fail","Fail");
        }
        return "redirect:/package/packages";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;
        Page<Package> packages = packageServices.findPaginated(pageNo, pageSize);
        List<Package> packageList = packages.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", packages.getTotalPages());
        model.addAttribute("packageList", packageList);
        return "management/PackageManagement/package-list";
    }
}
