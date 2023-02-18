package fivemonkey.com.fitnessbackend.entitties;

import jakarta.persistence.*;

@Entity
@Table(name = "category_blog", schema = "dbo")
public class CategoryBlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_blog;
}
