package fivemonkey.com.fitnessbackend.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
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

    //trainee-tracking relationship
    @OneToMany(mappedBy = "trainee")
    private List<Tracking> trackings;

    //trainee-user relationship
    @OneToOne
    @MapsId
    @JoinColumn(name = "trainee_email")
    private User user;

    //trainee-registration relationship
    @OneToMany(mappedBy = "trainee")
    private List<Registration> registrations;
}
