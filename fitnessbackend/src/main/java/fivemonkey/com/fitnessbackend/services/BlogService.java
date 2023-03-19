package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.BlogDTO;
import fivemonkey.com.fitnessbackend.entities.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {

    public List<BlogDTO> findAllBlogs();

    public BlogDTO findBlogById(Long id);

    public Blog save(BlogDTO b);

    public Blog update(BlogDTO b);

    public void disableBlogById(Long id);

    public void enableBlogById(Long id);

    public void delete(Long id);

}
