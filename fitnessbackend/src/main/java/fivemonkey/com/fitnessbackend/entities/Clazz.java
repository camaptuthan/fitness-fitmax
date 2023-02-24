package fivemonkey.com.fitnessbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "class", schema = "dbo")
public class Clazz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long id;

    @Column(name = "name")
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

    @Column(name = "image")
    private String img;
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
}
