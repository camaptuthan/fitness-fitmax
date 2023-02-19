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
@Table(name = "role", schema = "dbo")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_name")
    private String role_name;

    @Column(name = "description", columnDefinition = "TINYTEXT")
    private String description;

    @OneToMany(mappedBy = "role")
    private List<User> users = new ArrayList<>();

    @OneToOne(mappedBy = "role")
    private Manager manager;

    @OneToOne(mappedBy = "role")
    private Assistant assistant;

    @OneToOne(mappedBy = "role")
    private Trainer trainer;

    @OneToOne(mappedBy = "role")
    private Trainee trainee;
}
