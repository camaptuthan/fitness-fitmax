package fivemonkey.com.fitnessbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "position", schema = "dbo")
public class Position {

    @Id
    @GeneratedValue(generator = "position_generator")
    @GenericGenerator(name = "position_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.PositionIdentifier")
    @Column(name = "position_id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    //trainer-position relationship
    @ManyToMany(mappedBy = "positions", fetch = FetchType.LAZY)
    private List<Trainer> trainers;
}
