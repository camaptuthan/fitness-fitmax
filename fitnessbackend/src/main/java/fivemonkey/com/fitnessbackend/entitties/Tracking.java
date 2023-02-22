package fivemonkey.com.fitnessbackend.entitties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tracking", schema = "dbo")
public class Tracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tracking_id")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date created_date;

    //trainer-tracking relationship
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_email", referencedColumnName = "trainer_email")
    private Trainer trainer;

    //trainee-tracking relationship
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "trainee_email", referencedColumnName = "trainee_email")
    private Trainee trainee;

    //tracking-trackingDetail relationship
    @OneToMany(mappedBy = "tracking")
    private List<TrackingDetail> trackingDetails;
}
