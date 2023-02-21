package fivemonkey.com.fitnessbackend.entitties;

import javax.persistence.*;

import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

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

    @Column(name = "status", columnDefinition = "BOOLEAN")
    private boolean status;

    //user-registration relationship
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_email", referencedColumnName = "email")
    private User user;

    //registration-service relationship
//    @OneToMany(mappedBy = "registration")
//    private List<Services> services;
}
