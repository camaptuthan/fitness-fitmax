package fivemonkey.com.fitnessbackend.entities;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "studio_manager", schema = "dbo")
public class StudioManager {

    @Id
    @Column(name = "studio_manager_email")
    private String email;

    //studio-manager relationship
    @OneToOne(mappedBy = "studioManager")
    private Studio studio;

    //manager-user relationship
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "studio_manager_email")
    private User user;
}
