package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.entities.Category;
import fivemonkey.com.fitnessbackend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // get all category from repository
    @GetMapping("/all")
    public List<Category> getAllCategory() {
        return categoryService.findAllCategories();
    }

    //get category by type
    @GetMapping("/type/{type}")
    public List<Category> getCategoryByType(@PathVariable String type) {
        return categoryService.findAllCategoriesByType(type);
    }

}
