package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query("SELECT  b FROM Blog b ORDER BY b.date DESC")
    List<Blog> findTop3NewestBlogs();

    @Query("select b from Blog  b where CONCAT(b.description,'',b.category,'',b.title) like %?1% ")
    Page<Blog> findBlogByKeyword(String keyword, Pageable pageRequest);

    //get blog by category id
    @Query("select  b from Blog b where  b.category.id=?1")
    List<Blog> getAllByCategoryId(Long id);

}
