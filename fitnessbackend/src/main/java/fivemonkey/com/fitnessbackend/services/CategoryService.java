package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.entity.Category;
import fivemonkey.com.fitnessbackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public void addCategory(Category cate){
        categoryRepository.save(cate);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
