package fivemonkey.com.fitnessbackend.entitties;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "package", schema = "dbo")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private int duration;

    @Column(name = "price")
    private Float price;

    @Column(name = "description", columnDefinition = "TINYTEXT")
    private String des;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date date;

    @Column(name = "status", columnDefinition = "BOOLEAN")
    private boolean status;

    //service-package relationship
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    private Services services;
}
