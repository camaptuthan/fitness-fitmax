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
@Table(name = "nutrition", schema = "dbo")
public class Nutrition {

    @Id
    @GeneratedValue(generator = "nutrition_generator")
    @GenericGenerator(name = "nutrition_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.NutritionIdentifier")
    @Column(name = "nutrition_id")
    private String id;

    @Column(name = "nutrition_name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "calorie")
    private int calorie;

    @Column(name = "quantity")
    private int quantity;

    //trackingDetail-nutrition relationship
    @ManyToMany(mappedBy = "nutritionList", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TrackingDetail> trackingDetails;
}
