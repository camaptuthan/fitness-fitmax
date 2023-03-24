package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.BlogDTO;
import fivemonkey.com.fitnessbackend.entities.Blog;
import fivemonkey.com.fitnessbackend.entities.Category;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {

    public List<BlogDTO> findAllBlogs();

    public BlogDTO findBlogById(Long id);

    BlogDTO doBlog(BlogDTO blogDTO,User user, Category category);

    public Blog save(BlogDTO b);

    public Blog update(BlogDTO b);

    public void disableBlogById(Long id);

    public void enableBlogById(Long id);

    public void delete(Long id);

    List<Blog> findTop3NewestBlogs();

    Page<Blog> findBlogByKeyword(String keyword,int pageNumber);


}
