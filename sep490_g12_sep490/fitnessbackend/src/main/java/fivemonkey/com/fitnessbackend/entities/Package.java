package fivemonkey.com.fitnessbackend.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "package", schema = "dbo")
public class Package {

    @Id
    @GeneratedValue(generator = "package_generator")
    @GenericGenerator(name = "package_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.PackageIdentifier")
    @Column(name = "package_id")
    private String id;

    @NotEmpty(message = "{Size.Field.Name}")
    @Column(name = "package_name")
    private String name;

    @Column(name = "image")
    private String image;

    @Min(value = 1, message = "{Size.Field.Duration}")
    @Column(name = "duration")
    private int duration;

    @Min(value = 1, message = "{Size.Field.Price}")
    @Column(name = "price")
    private Float price;

    @Column(name = "description", columnDefinition = "text")
    private String des;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date date;

    @Column(name = "status", nullable = false)
    private boolean status;

    //service-package relationship
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", referencedColumnName = "service_id", unique = true)
    private Services services;

}
