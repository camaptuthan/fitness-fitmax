package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.CategoryDTO;
import fivemonkey.com.fitnessbackend.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<CategoryDTO> getAllCategories();
    List<CategoryDTO> getAllCategoriesByType(String type);

    CategoryDTO getCategoryById(Long id);

}
