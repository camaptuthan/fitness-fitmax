package fivemonkey.com.fitnessbackend.entitties;

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

    //manager-role relationship
    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", unique = true)
    private Role role;
}
