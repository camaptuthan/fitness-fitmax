package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.dto.BlogDTO;
import fivemonkey.com.fitnessbackend.entities.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {

    public List<BlogDTO> findAllBlogs();

    public BlogDTO findBlogById(String id);

    public Blog save(BlogDTO b);

    public Blog update(BlogDTO b);

    public void disableBlogById(String id);

    public void enableBlogById(String id);

    public void delete(String id);

}
