package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.BlogDTO;
import fivemonkey.com.fitnessbackend.entities.Blog;
import fivemonkey.com.fitnessbackend.entities.Category;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.service.service.BlogService;
import fivemonkey.com.fitnessbackend.service.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String blogInformation(Model model, @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
                                  @RequestParam(name = "category", required = false, defaultValue = "0") String category,
                                  @RequestParam(name = "pageNumber", required = false, defaultValue = "1") String pageNumber) {
        int totalPage = blogService.totalPageBy2Fields(keyword, Long.parseLong(category));
        List<Category> categoryList = categoryService.findBlogCategories();
        List<Blog> list = blogService.findBlogBy2Fields(keyword, Long.parseLong(category), Integer.parseInt(pageNumber) - 1);
        List<Blog> listNewestBlog = blogService.findTop3NewestBlogs();
        model.addAttribute("listBlog", list);
        model.addAttribute("size", list.size());
        model.addAttribute("listNewestBlog", listNewestBlog);
        model.addAttribute("catelist", categoryList);
        model.addAttribute("currentKeyword", keyword);
        model.addAttribute("currentCategory", category);
        model.addAttribute("currentPage", Integer.parseInt(pageNumber));
        if (totalPage == 0) {
            model.addAttribute("totalPage", totalPage + 1);
        }else {
            model.addAttribute("totalPage",totalPage);
        }
        return "/blog";
    }

    @GetMapping("/management/writer")
    public String blogWriter(@AuthenticationPrincipal UserDetail userDetail, Model model) {
        model.addAttribute("blogDTO", new BlogDTO());
        List<Category> categoryList = categoryService.findBlogCategories();
        model.addAttribute("catelist", categoryList);
        return "management/BlogManagement/blog_writer";
    }

    // Create new blog
    @PostMapping("/management/writer")
    public String blogWriter(@ModelAttribute("blogDTO") @Valid BlogDTO blogDTO,
                             @AuthenticationPrincipal UserDetail userDetail,
                             BindingResult result,
                             @RequestParam("category_id") String cateId) {
        Category category = new Category();
        category.setId(Long.parseLong(cateId));
        blogDTO.setCategory(category);
        if (result.hasErrors()) {
            return "management/BlogManagement/blog_writer";
        }
        blogService.doBlog(blogDTO, userDetail.getUser(), category);
        return "redirect:/blog";
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


    @GetMapping("/management")
    public String blogDashboard() {
        return "/management/Dashboard/service";
    }


}
