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
@Table(name = "studio", schema = "dbo")
public class Studio {

    @Id
    @GeneratedValue(generator = "studio_generator")
    @GenericGenerator(name = "studio_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.StudioIdentifier")
    @Column(name = "studio_id")
    private String id;

    @Column(name = "studio_name")
    private String name;

    @Column(name = "image", columnDefinition = "mediumblob")
    private byte[] image;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "contact")
    private String contact;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date date;

    @Column(name = "description", columnDefinition = "text")
    private String des;

    @Column(name = "status", nullable = false)
    private boolean status;

    //studio-user relationship
    @OneToMany(mappedBy = "studio")
    private List<User> users;

    //studio-service relationship
    @OneToMany(mappedBy = "studio")
    private List<Services> services;

    //studio-manager relationship
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_email", referencedColumnName = "manager_email", unique = true)
    private Manager manager;


}
