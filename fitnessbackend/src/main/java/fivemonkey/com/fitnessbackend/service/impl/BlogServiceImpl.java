package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.BlogDTO;
import fivemonkey.com.fitnessbackend.entities.*;
import fivemonkey.com.fitnessbackend.repository.BlogRepository;
import fivemonkey.com.fitnessbackend.repository.CategoryRepository;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import fivemonkey.com.fitnessbackend.service.service.BlogService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapperConfiguration<Blog, BlogDTO> modelMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SessionFactory sessionFactory;

    //get all blogs
    @Override
    public List<BlogDTO> findAllBlogs() {
        List<BlogDTO> blogDTOS = new ArrayList<>();
        List<Blog> blogs = blogRepository.findAll();
        for (Blog b : blogs) {
            BlogDTO blogDTO = modelMapper.map(b, BlogDTO.class);
            blogDTOS.add(blogDTO);
        }
        return blogDTOS;
    }

    //find blog by id
    @Override
    public BlogDTO findBlogById(Long id) {
        return modelMapper.map(blogRepository.getById(id), BlogDTO.class);
    }


    private Blog makeBlog(BlogDTO blogDTO, User user, Category category) {
        Blog blog = new Blog();
        blog.setUser(userRepository.getUserByEmail(user.getEmail()));
        blog.setCategory(categoryRepository.getById(category.getId()));
        blog.setStatus(1);
        blog.setTitle(blogDTO.getTitle());
        blog.setDescription(blogDTO.getDescription());
        blog.setThumbnail(blogDTO.getThumbnail());
        blog.setDate(new Date());
       return blog;
    }
    @Override
    public BlogDTO doBlog(BlogDTO blogDTO,User user, Category category) {
        return modelMapper.map(blogRepository.save(makeBlog(blogDTO, user, category)), BlogDTO.class);
    }
    //add new blog
    @Override
    public Blog save(BlogDTO b) {
        Blog blog = new Blog();
        blog.setTitle(b.getTitle());
        blog.setDescription(b.getDescription());
//      blog.setUser(userRepository.findByEmail(b.getUserEmail()).get());
        return blogRepository.save(blog);
    }

    @Override
    public Blog update(BlogDTO b) {
        try {
            Blog blog = blogRepository.getById(b.getId());
            blog.setTitle(b.getTitle());
            blog.setDescription(b.getDescription());
            blog.setThumbnail(b.getThumbnail());
            blog.setStatus(1);
            blog.setDate(b.getDate());
//            blog.setUser(new User(b.getUserEmail()));
            blog.setCategory(b.getCategory());
            return blogRepository.save(blog);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void disableBlogById(Long id) {
        Blog blog = blogRepository.getById(id);
        blog.setStatus(0);
        blogRepository.save(blog);
    }

    @Override
    public void enableBlogById(Long id) {
        Blog blog = blogRepository.getById(id);
        blog.setStatus(1);
        blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public List<Blog> findTop3NewestBlogs() {
        Session session = sessionFactory.openSession();
        String sql = "SELECT  b FROM Blog b ORDER BY b.date DESC";
        Query<Blog> query = session.createQuery(sql, Blog.class);
        query.setFirstResult(0);
        query.setMaxResults(3);
        return query.getResultList();
    }

    @Override
    public List<Blog> findBlogBy2Fields(String keyword, Long category, int pageNumber) {
        int pageSize = 3;
        Session session = sessionFactory.openSession();
        String sql = "select b from Blog b where b.id is not null ";
        if (!"".equals(keyword)) {
            sql += " and CONCAT(b.description,'',b.category,'',b.title) like '%" + keyword + "%' ";
        }
        if (category != 0L) {
            sql += " and b.category.id = " + category + " ";
        }
        Query<Blog> query = session.createQuery(sql, Blog.class);
        query.setFirstResult(pageNumber * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public int totalPageBy2Fields(String keyword, Long category) {
        int pageSize = 3;
        Session session = sessionFactory.openSession();
        String sqlcount = "select count(b.id) from Blog b where b.id is not null ";
        if (!"".equals(keyword)) {
            sqlcount += " and CONCAT(b.description,'',b.category,'',b.title) like '%" + keyword + "%' ";
        }
        if (category != 0L) {
            sqlcount += " and b.category.id = " + category + " ";
        }
        Query queryCount = session.createQuery(sqlcount);
        Long countResult = (Long) queryCount.uniqueResult();
        if ((int) (countResult % pageSize) != 0) {
            return (int) (countResult / pageSize) + 1;
        } else {
            return (int) (countResult / pageSize);
        }
    }


}
