package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.CategoryDTO;
import fivemonkey.com.fitnessbackend.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<CategoryDTO> getAllCategoriesByType(String type);

    CategoryDTO getCategoryDTOById(Long id);

    Category getCategoryById(Long id);

    public List<Category> findAllCategories();

    public Category save(CategoryDTO c);

    public Category update(CategoryDTO c);

    public List<Category> findBlogCategories();

}
