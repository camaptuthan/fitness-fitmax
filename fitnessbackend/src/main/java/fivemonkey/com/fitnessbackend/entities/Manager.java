package fivemonkey.com.fitnessbackend.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "manager", schema = "dbo")
public class Manager {

    @Id
    @Column(name = "manager_email")
    private String email;

    //studio-manager relationship
    @OneToOne(mappedBy = "manager")
    private Studio studio;

    //manager-user relationship
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @MapsId
    @JoinColumn(name = "manager_email")
    private User user;
}
