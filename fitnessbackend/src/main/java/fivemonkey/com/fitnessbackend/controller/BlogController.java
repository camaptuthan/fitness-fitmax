package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.BlogDTO;
import fivemonkey.com.fitnessbackend.entities.Blog;
import fivemonkey.com.fitnessbackend.entities.Category;
import fivemonkey.com.fitnessbackend.imageuploader.ImageUploader;
import fivemonkey.com.fitnessbackend.repository.BlogRepository;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.service.service.BlogService;
import fivemonkey.com.fitnessbackend.service.service.CategoryService;
import fivemonkey.com.fitnessbackend.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapperConfiguration<Blog, BlogDTO> modelMapper;

    @Autowired
    private ImageUploader imageUploader;

    @GetMapping("")
    public String getAllBlog(Model model, @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
                             @RequestParam(name = "category", required = false, defaultValue = "0") String category,
                             @RequestParam(name = "pageNumber", required = false, defaultValue = "1") String pageNumber) {
        int totalPage = blogService.totalPageBy2Fields(keyword, Long.parseLong(category));
        List<Category> categoryList = categoryService.findBlogCategories();
        List<Blog> list = blogService.findBlogBy2Fields(keyword, Long.parseLong(category), Integer.parseInt(pageNumber) - 1);
        List<BlogDTO> listBlog = modelMapper.mapList(list, BlogDTO.class);
        List<Blog> listNewestBlog = blogService.findTop3NewestBlogs();
        model.addAttribute("listBlog", listBlog);
        model.addAttribute("size", list.size());
        model.addAttribute("listNewestBlog", listNewestBlog);
        model.addAttribute("catelist", categoryList);
        model.addAttribute("currentKeyword", keyword);
        model.addAttribute("currentCategory", category);
        model.addAttribute("currentPage", Integer.parseInt(pageNumber));
        if (totalPage == 0) {
            model.addAttribute("totalPage", totalPage + 1);
        } else {
            model.addAttribute("totalPage", totalPage);
        }
        return "/user/blog";
    }

    @GetMapping("/blog-details/{id}")
    public String getBlogDetailInformation(@PathVariable("id") Long id, Model model, @AuthenticationPrincipal UserDetail userDetail,
                                           @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
                                           @RequestParam(name = "category", required = false, defaultValue = "0") String category,
                                           @RequestParam(name = "pageNumber", required = false, defaultValue = "1") String pageNumber) {
        int totalPage = blogService.totalPageBy2Fields(keyword, Long.parseLong(category));
        BlogDTO blogDTO = blogService.findBlogDTOById(id);
        Blog blog = blogService.findBlogById(id);
        List<Category> categoryList = categoryService.findBlogCategories();
        List<Blog> list = blogService.findBlogBy2Fields(keyword, Long.parseLong(category), Integer.parseInt(pageNumber) - 1);
        List<BlogDTO> listBlog = modelMapper.mapList(list, BlogDTO.class);
        List<Blog> listNewestBlog = blogService.findTop3NewestBlogs();
        blogDTO.setDescription(blogService.readBlogFromTextFile(blog));
        model.addAttribute("currentUser", userDetail);
        model.addAttribute("listBlog", listBlog);
        model.addAttribute("size", list.size());
        model.addAttribute("listNewestBlog", listNewestBlog);
        model.addAttribute("catelist", categoryList);
        model.addAttribute("currentKeyword", keyword);
        model.addAttribute("currentCategory", category);
        model.addAttribute("currentPage", Integer.parseInt(pageNumber));
        if (totalPage == 0) {
            model.addAttribute("totalPage", totalPage + 1);
        } else {
            model.addAttribute("totalPage", totalPage);
        }
        model.addAttribute("b", blogDTO);
        return "/user/blog_detail";
    }

    @GetMapping("/updateblog/{id}")
    public String getBlogInformation(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetail userDetail, Model model) {
        BlogDTO blogDTO = blogService.findBlogDTOById(id);
        Blog b = blogService.findBlogById(id);
        blogService.readBlogFromTextFile(b);
        blogDTO.setDescription(b.getDescription());
        List<Category> categoryList = categoryService.findBlogCategories();
        model.addAttribute("catelist", categoryList);
        model.addAttribute("blogDTO", blogDTO);
        model.addAttribute("authorEmail", userDetail.getUser().getEmail());
        return "/management/BlogManagement/blog-update";
    }

    @PostMapping("/updateblog/{id}")
    public String updateBlog(@ModelAttribute("blogDTO") BlogDTO blogDTO, @AuthenticationPrincipal UserDetail userDetail,
                             @RequestParam(name = "fileImage") MultipartFile multipartFile) {
        Blog blog = blogService.findBlogById(blogDTO.getId());
        if (multipartFile.isEmpty()) {
            blog.setThumbnail("https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/default_thumbnail.jpg?alt=media&token=ccac355b-48e3-4de5-95a1-6a8fc8905aaf");
        } else {
            blog.setThumbnail(imageUploader.upload(multipartFile));
        }
        if ("".equals(blogDTO.getTitle())) {
            blog.setTitle("Not have title yet.");
        } else {
            blog.setTitle(blogDTO.getTitle());
        }
        blog.setCategory(categoryService.getCategoryById(blogDTO.getCategoryId()));
        blogService.writeBlogToTextFile(blogDTO);
        if (userDetail.getUser().getRole().getId().equals("ROLE01") || userDetail.getUser().getRole().getId().equals("ROLE02") || userDetail.getUser().getRole().getId().equals("ROLE03")) {
            blog.setStatus(1);
        } else {
            blog.setStatus(0);
        }
        blog.setDate(new Date());
        blog.setUser(userService.getUserById(userDetail.getUser().getId()));
        blogRepository.save(blog);


        return "redirect:/blog";
    }

    @GetMapping("/newblog")
    public String blogWriter(@AuthenticationPrincipal UserDetail userDetail, Model model) {
        model.addAttribute("blogDTO", new BlogDTO());
        List<Category> categoryList = categoryService.findBlogCategories();
        model.addAttribute("authorEmail", userDetail.getUser().getEmail());
        model.addAttribute("catelist", categoryList);
        return "/management/BlogManagement/blog-writer";
    }

    // Create new blog
    @PostMapping("/newblog")
    public String addBlog(@ModelAttribute("blogDTO") @Valid BlogDTO blogDTO,
                          @AuthenticationPrincipal UserDetail userDetail,
                          @RequestParam(name = "fileImage") MultipartFile multipartFile) {
        Blog b = new Blog();
        if (multipartFile.isEmpty()) {
            b.setThumbnail("https://firebasestorage.googleapis.com/v0/b/fitness-fitmax-01.appspot.com/o/default_thumbnail.jpg?alt=media&token=ccac355b-48e3-4de5-95a1-6a8fc8905aaf");
        } else {
            b.setThumbnail(imageUploader.upload(multipartFile));
        }
        if ("".equals(blogDTO.getTitle())) {
            b.setTitle("Not have title yet.");
        } else {
            b.setTitle(blogDTO.getTitle());
        }
        b.setCategory(categoryService.getCategoryById(blogDTO.getCategoryId()));

        if (userDetail.getUser().getRole().getId().equals("ROLE01") || userDetail.getUser().getRole().getId().equals("ROLE02") || userDetail.getUser().getRole().getId().equals("ROLE03")) {
            b.setStatus(1);
        } else {
            b.setStatus(0);
        }
        b.setDate(new Date());
        b.setUser(userService.getUserById(userDetail.getUser().getId()));
        Blog newBlog = blogRepository.save(b);


        blogDTO.setId(newBlog.getId());
        newBlog.setDescription(blogService.writeBlogToTextFile(blogDTO));
        blogRepository.save(newBlog);

        return "redirect:/blog";
    }

    @GetMapping("/waiting-blog")
    public String getWaitingBlog(Model model, @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
                                 @RequestParam(name = "category", required = false, defaultValue = "0") String category,
                                 @RequestParam(name = "pageNumber", required = false, defaultValue = "1") String pageNumber) {
        int totalPage = blogService.totalWaitingBlogPage(keyword, Long.parseLong(category));
        List<Category> categoryList = categoryService.findBlogCategories();
        List<Blog> list = blogService.getAllWaitingBlog(keyword, Long.parseLong(category), Integer.parseInt(pageNumber) - 1);
        List<BlogDTO> listBlog = modelMapper.mapList(list, BlogDTO.class);
        List<Blog> listNewestBlog = blogService.findTop3NewestBlogs();
        model.addAttribute("listBlog", listBlog);
        model.addAttribute("size", list.size());
        model.addAttribute("listNewestBlog", listNewestBlog);
        model.addAttribute("catelist", categoryList);
        model.addAttribute("currentKeyword", keyword);
        model.addAttribute("currentCategory", category);
        model.addAttribute("currentPage", Integer.parseInt(pageNumber));
        if (totalPage == 0) {
            model.addAttribute("totalPage", totalPage + 1);
        } else {
            model.addAttribute("totalPage", totalPage);
        }
        return "/management/BlogManagement/blog-waiting";
    }

    @PostMapping("/approve/{id}")
    public String approveNewBlog(@PathVariable("id") Long id) {
        Blog b= blogService.findBlogById(id);
        b.setStatus(1);
        blogRepository.save(b);
        return "redirect:/blog";
    }

    @PostMapping("/reject/{id}")
    public String rejectNewBlog(@PathVariable("id") Long id) {
        Blog b= blogService.findBlogById(id);
        b.setStatus(2);
        blogRepository.save(b);
        return "redirect:/blog";
    }

    @GetMapping("/myblog")
    public String myBlog(Model model, @AuthenticationPrincipal UserDetail userDetail,
                         @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
                         @RequestParam(name = "category", required = false, defaultValue = "0") String category,
                         @RequestParam(name = "pageNumber", required = false, defaultValue = "1") String pageNumber) {
        List<Category> categoryList = categoryService.findBlogCategories();
        List<Blog> list = blogService.findMyBlogBy2Fields(userDetail.getUser().getId(), keyword, Long.parseLong(category), Integer.parseInt(pageNumber) - 1);
        List<BlogDTO> listBlog = modelMapper.mapList(list, BlogDTO.class);
        int totalPage = blogService.myBlogtotalPage(userDetail.getUser().getId(), keyword, Long.parseLong(category));
        model.addAttribute("listBlog", listBlog);
        model.addAttribute("size", list.size());
        model.addAttribute("catelist", categoryList);
        model.addAttribute("currentKeyword", keyword);
        model.addAttribute("currentCategory", category);
        model.addAttribute("currentPage", Integer.parseInt(pageNumber));
        if (totalPage == 0) {
            model.addAttribute("totalPage", totalPage + 1);
        } else {
            model.addAttribute("totalPage", totalPage);
        }
        return "/management/BlogManagement/my-blog";
    }
}
