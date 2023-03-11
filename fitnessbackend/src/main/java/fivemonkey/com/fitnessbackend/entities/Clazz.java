package fivemonkey.com.fitnessbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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

    @Column(name = "image")
    private String image;

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
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "service_id", referencedColumnName = "service_id", nullable = false, unique = true)
    private Services services;


    //class-session relationship
    @OneToMany(mappedBy = "aClass", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<Session> sessions;


}
