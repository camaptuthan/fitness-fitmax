package fivemonkey.com.fitnessbackend.entitties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String certificate;

    @Column(name = "exp")
    private String exp;

    @Column(name = "status", columnDefinition = "BOOLEAN")
    private boolean status;

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "trainer_position",
            joinColumns = {@JoinColumn(name = "trainer_id")},
            inverseJoinColumns = {@JoinColumn(name = "position_id")}
    )
    Set<Position> position = new HashSet<>();

    @OneToMany(mappedBy = "trainer")
    private List<PersonalTraining> personalTraining = new ArrayList<>();

    @OneToMany(mappedBy = "trainer")
    private List<Class> classes = new ArrayList<>();

    @OneToMany(mappedBy = "trainer")
    private List<Tracking> trackings = new ArrayList<>();
}
