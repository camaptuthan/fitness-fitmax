package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.BlogDTO;
import fivemonkey.com.fitnessbackend.entities.Blog;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.repository.BlogRepository;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import fivemonkey.com.fitnessbackend.service.service.BlogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapperConfiguration<Blog, BlogDTO> modelMapper;

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
        Blog blog = blogRepository.getById(id);
        BlogDTO blogDTO = new BlogDTO();
        ModelMapper mapper = new ModelMapper();
        blogDTO = mapper.map(blog, BlogDTO.class);
        return blogDTO;
    }

    //add new blog
    @Override
    public Blog save(BlogDTO b) {
        Blog blog = new Blog();
        blog.setTitle(b.getTitle());
        blog.setDescription(b.getDescription());
        blog.setStatus(1);
//        blog.setUser(userRepository.findByEmail(b.getUserEmail()).get());
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
        return blogRepository.findTop3NewestBlogs();
    }

    @Override
    public Page<Blog> findBlogByKeyword(String keyword,int pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber , 5);

        return blogRepository.findBlogByKeyword(keyword, pageable);
    }
}
