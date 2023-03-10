package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.BlogDTO;
import fivemonkey.com.fitnessbackend.dto.CategoryDTO;
import fivemonkey.com.fitnessbackend.entities.Category;
import fivemonkey.com.fitnessbackend.services.BlogService;
import fivemonkey.com.fitnessbackend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/listblogs")
    public String getAllBlogs(Model model) {
        List<BlogDTO> bloglist = blogService.findAllBlogs();
        List<Category> categoryList = categoryService.findAllCategoriesByType("blog");
        model.addAttribute("bloglist", bloglist);
        model.addAttribute("blogsize", bloglist.size());
        model.addAttribute("categoryList", categoryList);
        return "management/BlogManagement/blog-list";
    }

    @GetMapping("/addblog")
    public String addBlog(Model model) {
        List<Category> categoryList = categoryService.findAllCategoriesByType("blog");
        model.addAttribute("catelist", categoryList);
        model.addAttribute("newblog", new BlogDTO());
        return "management/BlogManagement/blog-add";
    }

    @PostMapping("/saveblog")
    public String saveBlog(@ModelAttribute("newblog") BlogDTO blogDTO, RedirectAttributes redirectAttributes){
        try{
            blogService.save(blogDTO);
            redirectAttributes.addFlashAttribute("success","Add successful!");
        }catch (Exception e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("fail","Add fail!");
        }
        return "redirect:/blog/listblogs";
    }


}
