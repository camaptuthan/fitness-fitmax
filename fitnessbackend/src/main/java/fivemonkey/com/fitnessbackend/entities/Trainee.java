package fivemonkey.com.fitnessbackend.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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

    //trainee-tracking relationship
    @OneToMany(mappedBy = "trainee")
    private List<Tracking> trackings;

    //trainee-user relationship
    @OneToOne
    @MapsId
    @JoinColumn(name = "trainee_email")
    private User user;

    //trainee-registration relationship
    @OneToMany(mappedBy = "trainee",cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Registration> registrations;

    public Trainee(String email) {
        this.email = email;
    }
}
