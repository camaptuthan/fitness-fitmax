package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.CategoryDTO;
import fivemonkey.com.fitnessbackend.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    public List<Category> findAllCategories();

    public CategoryDTO getCategoryById(String id);

    public Category save(CategoryDTO c);

    public Category update(CategoryDTO c);

    List<Category> findAllCategoriesByType(String type);
}
