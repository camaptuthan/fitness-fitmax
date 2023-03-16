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

    //assistant-studio relationship
    @OneToMany(mappedBy = "studio", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Assistant> assistants;

    //studio-studioManager relationship
    @OneToOne(mappedBy = "studio", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private StudioManager studioManager;

    //studio-district relationship
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id", referencedColumnName = "district_id", unique = true)
    private District district;

}
