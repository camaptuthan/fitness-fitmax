package fivemonkey.com.fitnessbackend.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "tracking", schema = "dbo")
public class Tracking {

    @Id
    @GeneratedValue(generator = "tracking_generator")
    @GenericGenerator(name = "tracking_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.TrackingIdentifier")
    @Column(name = "tracking_id")
    private String id;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date created_date;

    //trainer-tracking relationship
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_email", referencedColumnName = "trainer_email")
    private Trainer trainer;

    //trainee-tracking relationship
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "trainee_email", referencedColumnName = "trainee_email")
    private Trainee trainee;

    //tracking-trackingDetail relationship
    @OneToMany(mappedBy = "tracking",cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<TrackingDetail> trackingDetails;
}
