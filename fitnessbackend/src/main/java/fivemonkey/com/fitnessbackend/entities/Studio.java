package fivemonkey.com.fitnessbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Column(name = "image")
    private String image;

    @Column(name = "contact")
    private String contact;

    @Column(name = "address")
    private String address;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date date;

    @Column(name = "description", columnDefinition = "text")
    private String des;

    @Column(name = "status", nullable = false)
    private boolean status;

    //studio-studioManager relationship
    @OneToMany(mappedBy = "studio", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<User> users;

    //studio-district relationship
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id", referencedColumnName = "district_id", unique = true)
    private District district;

    //studio-service relationship
    @OneToMany(mappedBy = "studio", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Services> services;

}
