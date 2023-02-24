package fivemonkey.com.fitnessbackend.entities;

<<<<<<< HEAD
=======

import com.fasterxml.jackson.annotation.JsonIgnore;
>>>>>>> backend
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
@Table(name = "class", schema = "dbo")
public class Clazz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long id;

    @Column(name = "name")
    private String name;

<<<<<<< HEAD
    @Column(name = "slot")
    private int slot;

=======
>>>>>>> backend
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

<<<<<<< HEAD
    //service-class relationship
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
=======
    @Column(name = "image")
    private String img;
    //service-class relationship
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    @JsonIgnore
>>>>>>> backend
    private Services services;

    //trainer-class relationship
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_email", referencedColumnName = "trainer_email")
<<<<<<< HEAD
=======
    @JsonIgnore
>>>>>>> backend
    private Trainer trainer;

    //class-session relationship
    @OneToMany(mappedBy = "aClass")
<<<<<<< HEAD
    private List<Session> sessions;


    private String img;
=======
    @JsonIgnore
    private List<Session> sessions;

//    @Override
//    public String toString() {
//        return "Clazz{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", duration=" + duration +
//                ", price=" + price +
//                ", des='" + des + '\'' +
//                ", date=" + date +
//                ", status=" + status +
//                ", img='" + img + '\'' +
//                ", services=" + services +
//                ", trainer=" + trainer +
//                ", sessions=" + sessions +
//                '}';
//    }
>>>>>>> backend
}
