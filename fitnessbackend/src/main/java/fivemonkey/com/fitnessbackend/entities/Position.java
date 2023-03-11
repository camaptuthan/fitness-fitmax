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
@Table(name = "position", schema = "dbo")
public class Position {

    @Id
    @GeneratedValue(generator = "position_generator")
    @GenericGenerator(name = "position_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.PositionIdentifier")
    @Column(name = "position_id")
    private String id;

    @Column(name = "position_name")
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    //trainer-position relationship
    @ManyToMany(mappedBy = "positions", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Trainer> trainers;
}
