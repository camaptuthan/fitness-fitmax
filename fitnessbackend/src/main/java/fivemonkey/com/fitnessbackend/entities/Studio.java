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

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date date;

    @Column(name = "description", columnDefinition = "text")
    private String des;

    @Column(name = "status", nullable = false)
    private boolean status;


    //studio-district relationship
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id", referencedColumnName = "district_id", unique = true)
    private District district;

    @OneToMany(mappedBy = "studio", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<User> users;
    @OneToMany(mappedBy = "studio", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Services> services;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "studio_managers",
            joinColumns = { @JoinColumn(name = "studio_id") },
            inverseJoinColumns = {@JoinColumn(name = "user_id") })
    private Set<User> managers = new HashSet<>();

}
