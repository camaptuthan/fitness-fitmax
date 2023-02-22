package fivemonkey.com.fitnessbackend.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    //trainee-role relationship
    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", unique = true)
    private Role role;
}
