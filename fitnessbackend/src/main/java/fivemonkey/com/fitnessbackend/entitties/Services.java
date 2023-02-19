package fivemonkey.com.fitnessbackend.entitties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;


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
    private Long service_id;

    @Column(name = "service_name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date created_date;

    @ManyToOne
    @JoinColumn(name = "studio_id",referencedColumnName = "studio_id")
    private Studio studio;

    @ManyToMany
    @JoinTable(
            name = "service_category",
            joinColumns = {@JoinColumn(name = "service_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    List<Category> categoryList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "assistant_email", referencedColumnName = "assistant_email")
    private Assistant assistant;

    @OneToMany(mappedBy = "service")
    private List<Package> packages = new ArrayList<>();

    @OneToMany(mappedBy = "service")
    private List<PersonalTraining> personalTrainings = new ArrayList<>();

    @OneToMany(mappedBy = "service")
    private List<Class> classes = new ArrayList<>();

    @OneToOne(mappedBy = "service")
    private Registration registration;
}

