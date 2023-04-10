package fivemonkey.com.fitnessbackend.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "studio_id", referencedColumnName = "studio_id")
    private Studio studio;

    //service-category relationship
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    //registration-service relationship
    @OneToMany(mappedBy = "services")
    private List<Registration> registrations;

    //service-package relationship
    @OneToOne(mappedBy = "services")
    private Package aPackage;

    //service-personalTraining relationship
    @OneToOne(mappedBy = "services")
    private PersonalTraining personalTraining;

    //service-class relationship
    @OneToOne(mappedBy = "services")
    private Clazz clazz;

    //assistant-service relationship
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "assistant_email", referencedColumnName = "assistant_email")
    private Assistant assistant;

    //service-serviceType relationship
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_type_id", referencedColumnName = "service_type_id")
    private ServiceType serviceType;
}

