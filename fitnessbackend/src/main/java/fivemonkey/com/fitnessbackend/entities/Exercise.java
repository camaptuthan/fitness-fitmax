package fivemonkey.com.fitnessbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

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

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "rep")
    private int rep;

    @Column(name = "[set]")
    private int set;

    //trackingDetail-exercise relationship
    @ManyToMany(mappedBy = "exercises", fetch = FetchType.LAZY)
    private List<TrackingDetail> trackingDetails;
}
