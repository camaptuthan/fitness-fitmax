package fivemonkey.com.fitnessbackend.entities;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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
    @OneToMany(mappedBy = "trainer", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<PersonalTraining> personalTrainings;

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
    @MapsId
    @JoinColumn(name = "trainer_email")
    private User user;
}
