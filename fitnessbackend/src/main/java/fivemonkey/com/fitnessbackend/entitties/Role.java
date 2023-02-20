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

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "TINYTEXT")
    private String des;

    //role-user relationship
    @OneToMany(mappedBy = "role")
    private List<User> users;

    //manager-role relationship
    @OneToOne(mappedBy = "role")
    private Manager manager;

    //assistant-role relationship
    @OneToOne(mappedBy = "role")
    private Assistant assistant;

    //trainer-role relationship
    @OneToOne(mappedBy = "role")
    private Trainer trainer;

    //trainee-role relationship
    @OneToOne(mappedBy = "role")
    private Trainee trainee;
}
