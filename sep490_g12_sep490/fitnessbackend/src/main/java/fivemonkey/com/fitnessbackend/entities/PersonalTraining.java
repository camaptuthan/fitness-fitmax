package fivemonkey.com.fitnessbackend.entities;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "personal_training", schema = "dbo")
public class PersonalTraining {

    @Id
    @GeneratedValue(generator = "personal_training_generator")
    @GenericGenerator(name = "personal_training_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.PersonalTrainingIdentifier")
    @Column(name = "personaltraining_id")
    private String id;

    @Column(name = "personaltraining_name")
    private String name;

    @Column(name = "image")
    private String image;

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
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", referencedColumnName = "service_id", unique = true)
    private Services services;

    //trainer-personalTraining relationship
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "trainer_email", referencedColumnName = "trainer_email")
    private Trainer trainer;

}
