package fivemonkey.com.fitnessbackend.service;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.CategoryDTO;
import fivemonkey.com.fitnessbackend.entities.Category;
import fivemonkey.com.fitnessbackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapperConfiguration<Category, CategoryDTO> modelMapper;


    public List<CategoryDTO> getAllCategoriesByType(String type) {
        return modelMapper.mapList(categoryRepository.findCategoriesByType(type), CategoryDTO.class);
    }


    public CategoryDTO getCategoryDTOById(Long id) {
        return modelMapper.map(categoryRepository.findCategoryById(id), CategoryDTO.class);
    }


    public Category getCategoryById(Long id) {
        return categoryRepository.findCategoryById(id);
    }


    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }


    public Category save(CategoryDTO c) {
        return null;
    }


    public Category update(CategoryDTO c) {
        return null;
    }


    public List<Category> findBlogCategories() {
        return categoryRepository.findCategoriesByType("blog");
    }
}
