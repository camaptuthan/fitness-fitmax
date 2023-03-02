package fivemonkey.com.fitnessbackend.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;


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

    @Column(name = "image")
    private String img;
    //service-class relationship
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    @JsonIgnore
    private Services services;


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
