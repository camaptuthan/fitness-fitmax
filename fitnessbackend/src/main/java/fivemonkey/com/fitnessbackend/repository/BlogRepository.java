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


    @Query("select b from Blog  b where CONCAT(b.description,'',b.category,'',b.title) like %?1% ")
    Page<Blog> findBlogByKeyword(String keyword, Pageable pageRequest);

    @Query("select max(b.id) from Blog b order by b.id desc")
    Long findBlogMaxId();
}
