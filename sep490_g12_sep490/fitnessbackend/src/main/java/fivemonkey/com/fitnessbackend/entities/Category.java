package fivemonkey.com.fitnessbackend.entities;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
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

    @Column(name = "type")
    private String type;

    //blog-category relationship
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Blog> blogs;

    //service-category relationship
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Services> services;
}
