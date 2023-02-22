package fivemonkey.com.fitnessbackend.entities;
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
@Table(name = "registration", schema = "dbo")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "registration_date")
    private Date date;

    @Temporal(TemporalType.DATE)
    @Column(name = "started_date")
    private Date startDate;

    @Column(name = "status", nullable = false)
    private boolean status;

    //registration-service relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    private Services services;

    //trainee-registration relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_email", referencedColumnName = "trainee_email")
    private Trainee trainee;
}
