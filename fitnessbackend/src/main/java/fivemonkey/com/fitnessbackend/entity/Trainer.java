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
@Table(name = "trainer", schema = "dbo")
public class Trainer {

    @Id
    @Column(name = "trainer_email")
    private String email;

    @Column(name = "certificate")
    private String certi;

    @Column(name = "experience")
    private String exp;

    @Column(name = "status", nullable = false)
    private boolean status;

    //trainer-personalTraining relationship
    @OneToMany(mappedBy = "trainer")
    private List<PersonalTraining> personalTrainings;

    //trainer-class relationship
    @OneToMany(mappedBy = "trainer")
    private List<Clazz> classes;

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

    //trainer-user relationship
    @OneToOne
    @MapsId
    @JoinColumn(name = "trainer_email")
    private User user;
}
