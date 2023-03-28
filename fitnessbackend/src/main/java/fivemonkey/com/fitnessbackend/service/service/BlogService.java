package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.dto.BlogDTO;
import fivemonkey.com.fitnessbackend.entities.Blog;
import fivemonkey.com.fitnessbackend.entities.Category;
import fivemonkey.com.fitnessbackend.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {

    List<BlogDTO> findAllBlogs();

    BlogDTO findBlogDTOById(Long id);

    Blog findBlogById(Long id);

    BlogDTO doBlog(BlogDTO blogDTO,User user, Category category);

    Blog update(BlogDTO b);

    void disableBlogById(Long id);

    void enableBlogById(Long id);

    List<Blog> findTop3NewestBlogs();

    List<Blog> findBlogBy2Fields(String keyword, Long category, int pageNumber);

    List<Blog> findMyBlogBy2Fields(Long userId, String keyword, Long category, int pageNumber);

    List<Blog> getAllWaitingBlog(String keyword, Long category, int pageNumber);

    int totalPageBy2Fields(String keyword, Long category);

    int myBlogtotalPage(Long userId,String keyword, Long category);

    int totalWaitingBlogPage(String keyword, Long category);
}
