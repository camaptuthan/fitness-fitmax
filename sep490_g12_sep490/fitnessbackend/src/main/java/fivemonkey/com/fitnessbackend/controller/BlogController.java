package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.BlogDTO;
import fivemonkey.com.fitnessbackend.entities.Category;
import fivemonkey.com.fitnessbackend.services.BlogService;
import fivemonkey.com.fitnessbackend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public String blog() {
        return "/blog";
    }

    @GetMapping("/writer")
    public String blogWriter() {
        return "/blog_writer";
    }

    @GetMapping("/listblogs")
    public String getAllBlogs(Model model) {
        List<BlogDTO> list = blogService.findAllBlogs();
        model.addAttribute("list", list);
        model.addAttribute("size", list.size());
        return "management/blogmanagement/blog-list";
    }

    @GetMapping("/addblogs")
    public String addBlog(Model model) {
        List<Category> categoryList = categoryService.findAllCategories();
        model.addAttribute("catelist", categoryList);
        model.addAttribute("newblog", new BlogDTO());
        return null;
    }


}
