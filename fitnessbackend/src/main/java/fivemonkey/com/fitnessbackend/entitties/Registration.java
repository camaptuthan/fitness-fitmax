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
@Table(name = "registration", schema = "dbo")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "registration_date")
    private Date date;

    @Column(name = "status", columnDefinition = "BOOLEAN")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id")
    private Services service;
}
