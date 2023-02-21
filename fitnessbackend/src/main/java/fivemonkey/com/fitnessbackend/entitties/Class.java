package fivemonkey.com.fitnessbackend.entitties;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "class", schema = "dbo")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "slot")
    private int slot;

    @Column(name = "duration")
    private int duration;

    @Column(name = "price")
    private Float price;

    @Column(name = "description", columnDefinition = "TINYTEXT")
    private String des;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date date;

    @Column(name = "status", columnDefinition = "BOOLEAN")
    private boolean status;

    //service-class relationship
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    private Services services;

    //trainer-class relationship
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_email", referencedColumnName = "trainer_email")
    private Trainer trainer;

    //class-session relationship
    @OneToMany(mappedBy = "aClass")
    private List<Session> sessions;
}
