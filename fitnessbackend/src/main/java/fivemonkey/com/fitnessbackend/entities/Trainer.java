package fivemonkey.com.fitnessbackend.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.*;

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

    //trainer-session relationship
    @OneToMany(mappedBy = "trainer",cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.LAZY)
    private List<Session> sessions;

    //trainer-position relationship
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "trainer_position",
            joinColumns = {@JoinColumn(name = "trainer_email")},
            inverseJoinColumns = {@JoinColumn(name = "position_id")}
    )
    private List<Position> positions;

    //trainer-tracking relationship
    @OneToMany(mappedBy = "trainer",cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Tracking> trackings;

    //trainer-user relationship
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id", referencedColumnName = "user_id", unique = true)
    private User user;

    //trainer-registration relationship
    @Size(max = 3)
    @OneToMany(mappedBy = "trainer", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Registration> registrations;
}
