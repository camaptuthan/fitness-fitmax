package fivemonkey.com.fitnessbackend.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(generator = "category_generator")
    @GenericGenerator(name = "category_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.CategoryIdentifier")
    @Column(name = "category_id")
    private String id;

    @Column(name = "category_name")
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
