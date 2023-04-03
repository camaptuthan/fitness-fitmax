package fivemonkey.com.fitnessbackend.service;
import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.BlogDTO;
import fivemonkey.com.fitnessbackend.entities.Blog;
import fivemonkey.com.fitnessbackend.entities.Category;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.repository.BlogRepository;
import fivemonkey.com.fitnessbackend.repository.CategoryRepository;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class BlogService{

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapperConfiguration<Blog, BlogDTO> modelMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SessionFactory sessionFactory;

    //get all blogs
         
    public List<BlogDTO> findAllBlogs() {
        List<BlogDTO> blogDTOS = new ArrayList<>();
        List<Blog> blogs = blogRepository.findAll();
        for (Blog b : blogs) {
            BlogDTO blogDTO = modelMapper.map(b, BlogDTO.class);
            blogDTOS.add(blogDTO);
        }
        return blogDTOS;
    }

    //find blog by id
         
    public BlogDTO findBlogDTOById(Long id) {
        return modelMapper.map(blogRepository.getById(id), BlogDTO.class);
    }

         
    public Blog findBlogById(Long id) {
        return blogRepository.getById(id);
    }


    private Blog makeBlog(BlogDTO blogDTO, User user, Category category) {
        Blog blog = new Blog();
        blog.setUser(userRepository.getUserByEmail(user.getEmail()));
        blog.setCategory(categoryRepository.getById(category.getId()));
        blog.setStatus(1);
        blog.setTitle(blogDTO.getTitle());
        blog.setDescription(blogDTO.getDescription());
        blog.setThumbnail(blogDTO.getThumbnail());
        blog.setDate(new Date());
        return blog;
    }

         
    public BlogDTO doBlog(BlogDTO blogDTO, User user, Category category) {
        return modelMapper.map(blogRepository.save(makeBlog(blogDTO, user, category)), BlogDTO.class);
    }

         
    public String writeBlogToTextFile(BlogDTO blog) {
        try {
            Long blogId = blog.getId();
            FileWriter blogFile = new FileWriter("sep490_g12_sep490\\fitnessbackend\\blog\\blog_" + blogId + ".txt", false);
            blogFile.write(blog.getDescription());
            blogFile.close();
            return "sep490_g12_sep490\\fitnessbackend\\blog\\blog_" + blogId + ".txt";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

         
    public String readBlogFromTextFile(Blog blog) {
        if (blog.getDescription() != null) {
            try {
                FileReader blogFile = new FileReader(blog.getDescription());
                StringBuilder output = new StringBuilder();
                int i;
                while ((i = blogFile.read()) != -1) {
                    System.out.print((char) i);
                    output.append((char) i);
                }
                blogFile.close();
                return output.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

         
    public Blog update(BlogDTO b) {
        try {
            Blog blog = blogRepository.getById(b.getId());
            blog.setTitle(b.getTitle());
            blog.setDescription(b.getDescription());
            blog.setThumbnail(b.getThumbnail());
            blog.setStatus(1);
            blog.setDate(b.getDate());
            return blogRepository.save(blog);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

         
    public void disableBlogById(Long id) {
        Blog blog = blogRepository.getById(id);
        blog.setStatus(0);
        blogRepository.save(blog);
    }

         
    public void enableBlogById(Long id) {
        Blog blog = blogRepository.getById(id);
        blog.setStatus(1);
        blogRepository.save(blog);
    }

         
    public List<Blog> findTop3NewestBlogs() {
        Session session = sessionFactory.openSession();
        String sql = "SELECT  b FROM Blog b ORDER BY b.date DESC";
        Query<Blog> query = session.createQuery(sql, Blog.class);
        query.setFirstResult(0);
        query.setMaxResults(3);
        return query.getResultList();
    }

         
    public List<Blog> findBlogBy2Fields(String keyword, Long category, int pageNumber) {
        int pageSize = 3;
        Session session = sessionFactory.openSession();
        String sql = "select b from Blog b where b.status = 1 ";
        if (!"".equals(keyword)) {
            sql += " and CONCAT(b.description,'',b.category,'',b.title) like '%" + keyword + "%' ";
        }
        if (category != 0L) {
            sql += " and b.category.id = " + category + " ";
        }
        Query<Blog> query = session.createQuery(sql, Blog.class);
        query.setFirstResult(pageNumber * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

         
    public List<Blog> findMyBlogBy2Fields(Long userId, String keyword, Long category, int pageNumber) {
        int pageSize = 3;
        Session session = sessionFactory.openSession();
        String sql = "select b from Blog b where b.id is not null ";
        if (userId != 0L) {
            sql += " and b.user.id = " + userId + " ";
        }
        if (!"".equals(keyword)) {
            sql += " and CONCAT(b.description,'',b.category,'',b.title) like '%" + keyword + "%' ";
        }
        if (category != 0L) {
            sql += " and b.category.id = " + category + " ";
        }
        Query<Blog> query = session.createQuery(sql, Blog.class);
        query.setFirstResult(pageNumber * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

         
    public List<Blog> getAllWaitingBlog(String keyword, Long category, int pageNumber) {
        int pageSize = 3;
        Session session = sessionFactory.openSession();
        String sql = "select b from Blog b where b.status = 0 ";
        if (!"".equals(keyword)) {
            sql += " and CONCAT(b.description,'',b.category,'',b.title) like '%" + keyword + "%' ";
        }
        if (category != 0L) {
            sql += " and b.category.id = " + category + " ";
        }
        Query<Blog> query = session.createQuery(sql, Blog.class);
        query.setFirstResult(pageNumber * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

         
    public int totalPageBy2Fields(String keyword, Long category) {
        int pageSize = 3;
        Session session = sessionFactory.openSession();
        String sqlcount = "select count(b.id) from Blog b where b.status = 1 ";
        if (!"".equals(keyword)) {
            sqlcount += " and CONCAT(b.description,'',b.category,'',b.title) like '%" + keyword + "%' ";
        }
        if (category != 0L) {
            sqlcount += " and b.category.id = " + category + " ";
        }
        Query queryCount = session.createQuery(sqlcount);
        Long countResult = (Long) queryCount.uniqueResult();
        if ((int) (countResult % pageSize) != 0) {
            return (int) (countResult / pageSize) + 1;
        } else {
            return (int) (countResult / pageSize);
        }
    }

         
    public int myBlogtotalPage(Long userId, String keyword, Long category) {
        int pageSize = 3;
        Session session = sessionFactory.openSession();
        String sqlcount = "select count(b.id) from Blog b where b.id is not null ";
        if (userId != 0L) {
            sqlcount += " and b.user.id = " + userId + " ";
        }
        if (!"".equals(keyword)) {
            sqlcount += " and CONCAT(b.description,'',b.category,'',b.title) like '%" + keyword + "%' ";
        }
        if (category != 0L) {
            sqlcount += " and b.category.id = " + category + " ";
        }
        Query queryCount = session.createQuery(sqlcount);
        Long countResult = (Long) queryCount.uniqueResult();
        if ((int) (countResult % pageSize) != 0) {
            return (int) (countResult / pageSize) + 1;
        } else {
            return (int) (countResult / pageSize);
        }
    }

         
    public int totalWaitingBlogPage(String keyword, Long category) {
        int pageSize = 3;
        Session session = sessionFactory.openSession();
        String sqlcount = "select count(b.id) from Blog b where b.status = 0 ";
        if (!"".equals(keyword)) {
            sqlcount += " and CONCAT(b.description,'',b.category,'',b.title) like '%" + keyword + "%' ";
        }
        if (category != 0L) {
            sqlcount += " and b.category.id = " + category + " ";
        }
        Query queryCount = session.createQuery(sqlcount);
        Long countResult = (Long) queryCount.uniqueResult();
        if ((int) (countResult % pageSize) != 0) {
            return (int) (countResult / pageSize) + 1;
        } else {
            return (int) (countResult / pageSize);
        }
    }
}
