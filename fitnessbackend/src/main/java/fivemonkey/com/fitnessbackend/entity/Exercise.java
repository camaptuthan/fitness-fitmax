package fivemonkey.com.fitnessbackend.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "exercise", schema = "dbo")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "MEDIUMTEXT")
    private String description;

    @Column(name = "rep")
    private int rep;

    @Column(name = "set")
    private int set;

    //trackingDetail-exercise relationship
    @ManyToMany(mappedBy = "exercises")
    private List<TrackingDetail> trackingDetails;
}
