package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.BlogDTO;
import fivemonkey.com.fitnessbackend.entities.Blog;
import fivemonkey.com.fitnessbackend.entities.Category;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.services.BlogService;
import fivemonkey.com.fitnessbackend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("")
    public String category(Model model,  String keyword,@RequestParam(name = "page", defaultValue = "0") int pageNumber){
        List<Category> categoryList = categoryService.findAllCategories();
        Page<Blog> list = blogService.findBlogByKeyword(keyword,pageNumber);
        List<BlogDTO> listAll=blogService.findAllBlogs();
        List<Blog> listNewestBlog=blogService.findTop3NewestBlogs();
        if(keyword==null){
            model.addAttribute("listBlog", listAll);
        }else{
            model.addAttribute("listBlog", list);
            model.addAttribute("size", list.getSize());
        }
        model.addAttribute("listNewestBlog", listNewestBlog);
        model.addAttribute("catelist", categoryList);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", list.getTotalPages());
        model.addAttribute("keyword", keyword);
        return "/blog";
    }
    @GetMapping("/management/writer")
    public String blogWriter(Model model) {
        model.addAttribute("blogDTO", new BlogDTO());
        return "management/BlogManagement/blog_writer";
    }

    @PostMapping("/management/writer")
    public String blogWriter(@ModelAttribute("blogDTO") @Valid BlogDTO blogDTO, @AuthenticationPrincipal UserDetail userDetail, BindingResult result, RedirectAttributes attributes) {
        blogDTO.setUserEmail(userDetail.getUser().getEmail());
        blogService.save(blogDTO);
        System.out.println("Huy: " + blogDTO.getDescription());
        return "redirect:/";
    }

    @GetMapping("/management/blogs")
    public String getAllBlogs(Model model) {
        List<BlogDTO> list = blogService.findAllBlogs();
        model.addAttribute("list", list);
        model.addAttribute("size", list.size());
        return "management/BlogManagement/blog-list";
    }

    @GetMapping("/addblogs")
    public String addBlog(Model model) {
        List<Category> categoryList = categoryService.findAllCategories();
        model.addAttribute("catelist", categoryList);
        model.addAttribute("newblog", new BlogDTO());
        return null;
    }





}
