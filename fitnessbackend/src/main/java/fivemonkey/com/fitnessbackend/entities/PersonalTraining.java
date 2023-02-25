package fivemonkey.com.fitnessbackend.entities;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "personal_training", schema = "dbo")
public class PersonalTraining {

    @Id
    @GeneratedValue(generator = "personal_training_generator")
    @GenericGenerator(name = "personal_training_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.PersonalTrainingIdentifier")
    @Column(name = "personaltraining_id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "slot")
    private int slot;

    @Column(name = "price")
    private Float price;

    @Column(name = "duration")
    private int duration;

    @Column(name = "description", columnDefinition = "text")

    private String des;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date date;

    @Column(name = "status", nullable = false)
    private boolean status;

    //service-personalTraining relationship
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    private Services services;

    //trainer-personalTraining relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_email", referencedColumnName = "trainer_email")
    private Trainer trainer;
}
