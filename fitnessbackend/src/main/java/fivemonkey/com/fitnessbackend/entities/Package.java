package fivemonkey.com.fitnessbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "package", schema = "dbo")
public class Package {

    @Id
    @GeneratedValue(generator = "package_generator")
    @GenericGenerator(name = "package_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.PackageIdentifier")
    @Column(name = "package_id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private int duration;

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
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    private Services services;
}
