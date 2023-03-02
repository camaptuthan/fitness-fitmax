package fivemonkey.com.fitnessbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "image", schema = "dbo")
public class Image {

    @Id
    @GeneratedValue(generator = "image_generator")
    @GenericGenerator(name = "image_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.ImageIdentifier")
    @Column(name = "image_id")
    private String id;

    @Column(name = "image_link")
    private String link;

    //blog-image relationship
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_id", referencedColumnName = "blog_id")
    private Blog blog;

    //studio-image relationship
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "studio_id", referencedColumnName = "studio_id")
    private Studio studio;

    //package-image relationship
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id", referencedColumnName = "package_id")
    private Package aPackage;

    //class-image relationship
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private Clazz clazz;

    //personalTraining relationship
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "personaltraining_id", referencedColumnName = "personaltraining_id")
    private PersonalTraining personalTraining;
}
