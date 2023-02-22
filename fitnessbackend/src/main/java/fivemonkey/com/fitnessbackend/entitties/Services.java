package fivemonkey.com.fitnessbackend.entitties;

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
@Table(name = "service", schema = "dbo")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status", nullable = false)
    private boolean status;

    //studio-service relationship
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "studio_id", referencedColumnName = "studio_id")
    private Studio studio;

    //service-category relationship
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "service_category",
            joinColumns = {@JoinColumn(name = "service_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private List<Category> categoryList;

    //registration-service relationship
    @OneToMany(mappedBy = "services")
    private List<Registration> registrations;

    //service-package relationship
    @OneToMany(mappedBy = "services")
    private List<Package> packages;

    //service-personalTraining relationship
    @OneToMany(mappedBy = "services")
    private List<PersonalTraining> personalTrainings;

    //service-class relationship
    @OneToMany(mappedBy = "services")
    private List<Clazz> classes;

    //assistant-service relationship
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "assistant_email", referencedColumnName = "assistant_email")
    private Assistant assistant;
}

