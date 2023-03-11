package fivemonkey.com.fitnessbackend.entities;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "blog", schema = "dbo")
public class Blog {

    @Id
    @GeneratedValue(generator = "blog_generator")
    @GenericGenerator(name = "blog_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.BlogIdentifier")
    @Column(name = "blog_id")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date date;

    @Column(name = "image")
    private String image;

    @Column(name = "status", nullable = false)
    private boolean status;

    //user-blog relationship
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_email", referencedColumnName = "email")
    private User user;

    //blog-category relationship
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

}
