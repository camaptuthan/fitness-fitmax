package fivemonkey.com.fitnessbackend.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category", schema = "dbo")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String des;

    //blog-category relationship
    @ManyToMany(mappedBy = "categoryList", fetch = FetchType.LAZY)
    private List<Blog> blogs;

    //service-category relationship
    @ManyToMany(mappedBy = "categoryList", fetch = FetchType.LAZY)
    private List<Services> services;
}
