package fivemonkey.com.fitnessbackend.entities;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "manager_email")
    private User user;
}
