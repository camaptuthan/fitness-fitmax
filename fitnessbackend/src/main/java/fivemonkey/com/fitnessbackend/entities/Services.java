package fivemonkey.com.fitnessbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @Column(name = "image")
    private String image;
    @Min(value = 1, message = "{Size.Field.Duration}")
    @Column(name = "duration")
    private int duration;

    @Min(value = 1, message = "{Size.Field.Price}")
    @Column(name = "price")
    private Float price;
    @Column(name = "description", columnDefinition = "longtext")
    private String des;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date date;

    @Min(value = 0)
    @Max(value = 3)
    @Column(name = "status", nullable = false)
    private int status;

    //city-service relationship
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private City city;

    //studio service relationship
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "studio_id", referencedColumnName = "studio_id", nullable = true)
    private Studio studio;

    //service-category relationship
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    //registration-service relationship
    @OneToMany(mappedBy = "services")
    private List<Registration> registrations;

    //service-class relationship
    @OneToOne(mappedBy = "services")
    private Clazz clazz;

    //service-serviceType relationship
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_type_id", referencedColumnName = "service_type_id")
    private ServiceType serviceType;

    //user-service realtionship
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "user_id", nullable = true)
    private User user;
}

