package fivemonkey.com.fitnessbackend.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @Column(name = "image", columnDefinition = "mediumblob")
    private byte[] image;

    @NotNull(message = "Not null")
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
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", referencedColumnName = "service_id", unique = true)
    private Services services;


    //class-session relationship
    @OneToMany(mappedBy = "aClass")
    @JsonIgnore
    private List<Session> sessions;

}
