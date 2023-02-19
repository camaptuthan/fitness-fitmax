package fivemonkey.com.fitnessbackend.entitties;

import jakarta.persistence.*;
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

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;

    @OneToOne
    @JoinColumn(name = "studio_id", referencedColumnName = "studio_id")
    private Studio studio;
}
