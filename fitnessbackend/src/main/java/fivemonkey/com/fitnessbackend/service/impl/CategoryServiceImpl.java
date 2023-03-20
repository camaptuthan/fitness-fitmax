package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.CategoryDTO;
import fivemonkey.com.fitnessbackend.entities.Category;
import fivemonkey.com.fitnessbackend.repository.CategoryRepository;
import fivemonkey.com.fitnessbackend.service.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapperConfiguration<Category, CategoryDTO> modelMapper;

    @Override
    public List<CategoryDTO> getAllCategoriesByType(String type) {
        return modelMapper.mapList(categoryRepository.findCategoriesByType(type), CategoryDTO.class);
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        return modelMapper.map(categoryRepository.findCategoryById(id), CategoryDTO.class);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(CategoryDTO c) {
        return null;
    }

    @Override
    public Category update(CategoryDTO c) {
        return null;
    }

    @Override
    public List<Category> findBlogCategories() {
        return categoryRepository.findCategoriesByType("blog");
    }
}
