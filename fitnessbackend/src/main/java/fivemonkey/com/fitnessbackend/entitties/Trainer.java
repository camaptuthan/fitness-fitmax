package fivemonkey.com.fitnessbackend.entitties;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.parameters.P;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "trainer", schema = "dbo")
public class Trainer {

    @Id
    @Column(name = "trainer_email")
    private String email;

    @Column(name = "certificate")
    private String certi;

    @Column(name = "experience")
    private String exp;

    @Column(name = "status", columnDefinition = "BOOLEAN")
    private boolean status;

    //trainer-personalTraining relationship
    @OneToMany(mappedBy = "trainer")
    private List<PersonalTraining> personalTrainings;

    //trainer-class relationship
    @OneToMany(mappedBy = "trainer")
    private List<Class> classes;

    //trainer-position relationship
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "trainer_position",
            joinColumns = {@JoinColumn(name = "trainer_email")},
            inverseJoinColumns = {@JoinColumn(name = "position_id")}
    )
    private List<Position> positions;

    //trainer-tracking relationship
    @OneToMany(mappedBy = "trainer")
    private List<Tracking> trackings;

    //trainer-role relationship
    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", unique = true)
    private Role role;
}
