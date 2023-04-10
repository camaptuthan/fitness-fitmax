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
@Table(name = "trackingdetail", schema = "dbo")
public class TrackingDetail {

    @Id
    @GeneratedValue(generator = "trackingdetail_generator")
    @GenericGenerator(name = "trackingdetail_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.TrackingDetailIdentifier")
    @Column(name = "trackingdetail_id")
    private String id;

    @Column(name = "height")
    private Double height;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "chest")
    private Double chest;

    @Column(name = "bicep")
    private Double bicep;

    @Column(name = "waist")
    private Double waist;

    @Column(name = "hips")
    private Double hips;

    @Column(name = "thigh")
    private Double thigh;

    //tracking-trackingDetail relationship
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "tracking_id", referencedColumnName = "tracking_id")
    private Tracking tracking;

    //trackingDetail-exercise relationship
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "trackingdetail_exercise",
            joinColumns = {@JoinColumn(name = "trackingdetail_id")},
            inverseJoinColumns = {@JoinColumn(name = "exercise_id")}
    )
    private List<Exercise> exercises;

    //trackingDetail-nutrition relationship
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "trackingdetail_nutrition",
            joinColumns = {@JoinColumn(name = "trackingdetail_id")},
            inverseJoinColumns = {@JoinColumn(name = "nutrition_id")}
    )
    private List<Nutrition> nutritionList;

    //trackingDetail-session relationship
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", referencedColumnName = "schedule_id", unique = true)
    private Schedule schedule;
}
