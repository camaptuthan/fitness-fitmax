package fivemonkey.com.fitnessbackend.entities;

import lombok.*;

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
@Table(name = "trainee", schema = "dbo")
public class Trainee {

    @Id
    @Column(name = "trainee_email")
    private String email;

    @Column(name = "height")
    private Double height;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "city_switch")
    private String citySwitch;

    @Column(name = "studio_switch")
    private String studioSwitch;

    @Column(name = "service_switch")
    private String serviceSwitch;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date date;
    @Min(value = 0)
    @Max(value = 3)
    @Column(name = "status_sw",nullable = false)
    private int statusSw;
    //trainee-tracking relationship
    @OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY)
    private List<Tracking> trackings;

    //trainee-history relationship
    @OneToMany(mappedBy = "trainee", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<History> histories;

    //trainee-user relationship
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "trainee_id", referencedColumnName = "user_id", unique = true)
    private User user;

    //trainee-registration relationship
    @OneToMany(mappedBy = "trainee", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Registration> registrations;

    public Trainee(String email) {
        this.email = email;
    }
}
