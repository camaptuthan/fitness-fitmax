package fivemonkey.com.fitnessbackend.service;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.CategoryDTO;
import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.entities.Category;
import fivemonkey.com.fitnessbackend.entities.Clazz;
import fivemonkey.com.fitnessbackend.repository.CategoryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapperConfiguration<Category, CategoryDTO> modelMapper;

    @Autowired
    private SessionFactory sessionFactory;


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

    public List<String> getAllCategoryType(){
        return categoryRepository.getAllCategoryType();
    }


    public List<Category> findBlogCategories() {
        return categoryRepository.findCategoriesByType("blog");
    }

    public List<CategoryDTO> findCategoryBy2Fields(String type, int page){
        int pageSize = 5;
        Session session = sessionFactory.openSession();
        String sql = "select c from Category c where c.id is not null ";
        if (!"All".equals(type)) {
            sql += " and c.type = '" + type + "' ";
        }
        Query<Category> query1 = session.createQuery(sql, Category.class);
        query1.setFirstResult(page * pageSize);
        query1.setMaxResults(pageSize);
        return modelMapper.mapList(query1.getResultList(), CategoryDTO.class);
    }

    public int totalPageCategory(String type){
        int pageSize = 5;
        Session session = sessionFactory.openSession();
        String sql = "select count(c.id) from Category c where c.id is not null ";
        if (!"All".equals(type)) {
            sql += " and c.type = '" + type + "' ";
        }
        Query queryCount = session.createQuery(sql);
        Long countResult = (Long) queryCount.uniqueResult();
        if ((int) (countResult % pageSize) != 0) {
            return (int) (countResult / pageSize) + 1;
        } else {
            return (int) (countResult / pageSize);
        }
    }
}
