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

//    @OneToOne(mappedBy = "manager")

}
