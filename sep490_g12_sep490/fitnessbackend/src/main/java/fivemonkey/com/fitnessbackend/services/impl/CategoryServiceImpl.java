package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.dto.CategoryDTO;
import fivemonkey.com.fitnessbackend.entities.Category;
import fivemonkey.com.fitnessbackend.repository.CategoryRepository;
import fivemonkey.com.fitnessbackend.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryDTO getCategoryById(String id) {
        Category c = categoryRepository.getById(id);
        CategoryDTO categoryDTO = new CategoryDTO();
        ModelMapper mapper = new ModelMapper();
        categoryDTO = mapper.map(c, CategoryDTO.class);
        return categoryDTO;
    }

    @Override
    public Category save(CategoryDTO c) {
        Category category = new Category();
        category.setName(c.getName());
        category.setDes(c.getDes());
        category.setType(c.getType());
        return categoryRepository.save(category);
    }

    @Override
    public Category update(CategoryDTO c) {
        try {
            Category category = categoryRepository.getById(c.getId());
            category.setName(c.getName());
            category.setDes(c.getDes());
            category.setType(c.getType());
            return categoryRepository.save(category);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> findAllCategoriesByType(String type) {
        return categoryRepository.findAllByType(type);
    }
}
