package fivemonkey.com.fitnessbackend.entitties;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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

    @ManyToOne
    @JoinColumn(name = "trainer_email", referencedColumnName = "trainer_email")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "trainee_email", referencedColumnName = "trainee_email")
    private Trainee trainee;

}
