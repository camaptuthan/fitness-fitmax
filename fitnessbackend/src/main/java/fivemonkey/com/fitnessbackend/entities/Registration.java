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
@Table(name = "registration", schema = "dbo")
public class Registration {

    @Id
    @GeneratedValue(generator = "registration_generator")
    @GenericGenerator(name = "registration_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.RegistrationIdentifier")
    @Column(name = "registration_id")
    private String id;

    @Temporal(TemporalType.DATE)
    @Column(name = "registration_date")
    private Date date;

    @Temporal(TemporalType.DATE)
    @Column(name = "started_date")
    private Date startDate;


    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "approved_by")
    private String approvedBy;

    //registration-service relationship
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "service_id", referencedColumnName = "service_id", nullable = false)
    private Services services;

    //trainee-registration relationship
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_email", referencedColumnName = "trainee_email", nullable = false)
    private Trainee trainee;

    //assistant-registration relationship
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "assistant_email", referencedColumnName = "assistant_email")
    private Assistant assistant;
}
