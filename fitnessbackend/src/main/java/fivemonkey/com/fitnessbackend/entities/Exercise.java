package fivemonkey.com.fitnessbackend.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "exercise", schema = "dbo")
public class Exercise {

    @Id
    @GeneratedValue(generator = "exercise_generator")
    @GenericGenerator(name = "exercise_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.ExerciseIdentifier")
    @Column(name = "exercise_id")
    private String id;
    @Column(name = "exercise_name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "rep")
    private int rep;

    @Column(name = "[set]")
    private int set;

    //trackingDetail-exercise relationship
    @ManyToMany(mappedBy = "exercises", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TrackingDetail> trackingDetails;
}
