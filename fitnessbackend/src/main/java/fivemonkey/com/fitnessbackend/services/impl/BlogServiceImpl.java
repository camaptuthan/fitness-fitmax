package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.dto.BlogDTO;
import fivemonkey.com.fitnessbackend.entities.Blog;
import fivemonkey.com.fitnessbackend.repository.BlogRepository;
import fivemonkey.com.fitnessbackend.services.BlogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    ModelMapper modelMapper;

    //get all blogs
    @Override
    public List<BlogDTO> findAllBlogs() {
        List<BlogDTO> blogDTOS = new ArrayList<>();
        List<Blog> blogs = blogRepository.findAll();
        for (Blog b: blogs) {
            BlogDTO blogDTO = modelMapper.map(b, BlogDTO.class);
            blogDTOS.add(blogDTO);
        }
        return blogDTOS;
    }

    //find blog by id
    @Override
    public BlogDTO findBlogById(String id) {
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
        blog.setDescription(b.getDes());
        blog.setImage(b.getImage());
        blog.setStatus(true);
        blog.setDate(b.getCreated_date());
        blog.setUser(b.getWriter_email());
        blog.setCategory(b.getCategory());
        return blogRepository.save(blog);
    }

    @Override
    public Blog update(BlogDTO b) {
        try{
            Blog blog = blogRepository.getById(b.getId());
            blog.setTitle(b.getTitle());
            blog.setDescription(b.getDes());
            blog.setImage(b.getImage());
            blog.setStatus(true);
            blog.setDate(b.getCreated_date());
            blog.setUser(b.getWriter_email());
            blog.setCategory(b.getCategory());
            return blogRepository.save(blog);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void disableBlogById(String id) {
        Blog blog = blogRepository.getById(id);
        blog.setStatus(false);
        blogRepository.save(blog);
    }

    @Override
    public void enableBlogById(String id) {
        Blog blog = blogRepository.getById(id);
        blog.setStatus(true);
        blogRepository.save(blog);
    }

    @Override
    public void delete(String id) {

    }
}
