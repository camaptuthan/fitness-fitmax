package fivemonkey.com.fitnessbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "class", schema = "dbo")
public class Clazz {

    @Id
    @GeneratedValue(generator = "class_generator")
    @GenericGenerator(name = "class_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.ClassIdentifier")
    @Column(name = "class_id")
    private String id;

    @Column(name = "class_name")
    private String name;

    @Column(name = "duration")
    private int duration;

    @Column(name = "price")
    private Float price;

    @Column(name = "description", columnDefinition = "text")
    private String des;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date date;

    @Column(name = "status", nullable = false)
    private boolean status;

    //service-class relationship
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    @JsonIgnore
    private Services services;

    //trainer-class relationship
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_email", referencedColumnName = "trainer_email")
    @JsonIgnore
    private Trainer trainer;

    //class-session relationship
    @OneToMany(mappedBy = "aClass")
    @JsonIgnore
    private List<Session> sessions;


    private String img;
}
