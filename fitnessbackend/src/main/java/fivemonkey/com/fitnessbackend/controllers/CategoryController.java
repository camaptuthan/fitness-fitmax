package fivemonkey.com.fitnessbackend.controllers;

import fivemonkey.com.fitnessbackend.entitties.Category;
import fivemonkey.com.fitnessbackend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serviceCategory")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping("/add")
    public void addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
