package fivemonkey.com.fitnessbackend.entitties;

import javax.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "personal_training", schema = "dbo")
public class PersonalTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PT_id")
    private Long id;

    @Column(name = "slot")
    private int slot;

    @Column(name = "price")
    private Double price;

    @Column(name = "duration")
    private int duration;

    @Column(name = "descripiton", columnDefinition = "TINYTEXT")
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date date;

    @Column(name = "status", columnDefinition = "BOOLEAN")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    private Services service;
}
