package fivemonkey.com.fitnessbackend.entitties;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tracking_detail", schema = "dbo")
public class TrackingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tracking_detail_id")
    private Long id;

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

    @ManyToMany
    @JoinTable(
            name = "trackingDetail_nutrition",
            joinColumns = {@JoinColumn(name = "tracking_detail_id")},
            inverseJoinColumns = {@JoinColumn(name = "nutrition_id")}
    )
    List<Nutrition> nutritionList = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "trackingDetail_exercise",
            joinColumns = {@JoinColumn(name = "tracking_detail_id")},
            inverseJoinColumns = {@JoinColumn(name = "exercise_id")}
    )
    List<Exercise> exercises = new ArrayList<>();
}
