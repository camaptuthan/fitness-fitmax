package fivemonkey.com.fitnessbackend.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "district", schema = "dbo")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_id")
    private Long id;

    @Column(name = "district_name")
    private String name;

    @Column(name = "road")
    private String road;

    //city-district relationship
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private City city;

    //studio-city relationship
    @OneToOne(mappedBy = "district", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Studio studios;
}
