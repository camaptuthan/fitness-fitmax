package fivemonkey.com.fitnessbackend.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "city", schema = "dbo")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private long id;

    @Column(name = "city_name")
    private String name;

    //city-district relationship
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<District> districts;


}
