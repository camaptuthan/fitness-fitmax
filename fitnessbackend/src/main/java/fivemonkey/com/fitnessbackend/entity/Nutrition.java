package fivemonkey.com.fitnessbackend.entity;

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
@Table(name = "nutrition", schema = "dbo")
public class Nutrition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nutrition_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "calorie")
    private int calorie;

    @Column(name = "quantity")
    private int quantity;

    //trackingDetail-nutrition relationship
    @ManyToMany(mappedBy = "nutritionList", fetch = FetchType.LAZY)
    private List<TrackingDetail> trackingDetails;
}
