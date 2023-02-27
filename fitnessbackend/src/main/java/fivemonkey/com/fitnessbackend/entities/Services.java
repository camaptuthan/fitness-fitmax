package fivemonkey.com.fitnessbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "service", schema = "dbo")
public class Services {

    @Id
    @GeneratedValue(generator = "service_generator")
    @GenericGenerator(name = "service_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.ServiceIdentifier")
    @Column(name = "service_id")
    private String id;

    @Column(name = "service_name")
    private String name;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date date;

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

//    @Override
//    public String toString() {
//        return "Services{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", status=" + status +
//                ", studio=" + studio +
//                ", categoryList=" + categoryList +
//                ", registrations=" + registrations +
//                ", packages=" + packages +
//                ", personalTrainings=" + personalTrainings +
//                ", classes=" + classes +
//                ", assistant=" + assistant +
//                '}';
//    }
}

