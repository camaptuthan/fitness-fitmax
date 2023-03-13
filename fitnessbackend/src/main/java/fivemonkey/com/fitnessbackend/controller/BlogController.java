package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.BlogDTO;
import fivemonkey.com.fitnessbackend.entities.Category;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.services.BlogService;
import fivemonkey.com.fitnessbackend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
    public String blogWriter(Model model) {
        model.addAttribute("blogDTO", new BlogDTO());
        return "/blog_writer";
    }

    @PostMapping("/writer")
    public String blogWriter(@ModelAttribute("blogDTO") @Valid BlogDTO blogDTO, @AuthenticationPrincipal UserDetail userDetail, BindingResult result, RedirectAttributes attributes) {
        blogDTO.setUserEmail(userDetail.getUser().getEmail());
        System.out.println("Huy: " + blogDTO.getDes());
        return "redirect:/";
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
