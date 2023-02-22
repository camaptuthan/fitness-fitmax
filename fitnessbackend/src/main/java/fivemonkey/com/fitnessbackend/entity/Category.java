package fivemonkey.com.fitnessbackend.entity;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "description", columnDefinition = "TINYTEXT")
    private String des;

    //blog-category relationship
    @ManyToMany(mappedBy = "categoryList")
    private List<Blog> blogs;

    //service-category relationship
    @ManyToMany(mappedBy = "categoryList")
    private List<Services> services;
}
