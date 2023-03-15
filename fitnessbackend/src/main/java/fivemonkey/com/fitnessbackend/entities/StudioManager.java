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

    //manager-user relationship
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "studio_manager_email")
    private User user;

    //studio-studioManager relationship
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "studio_id", referencedColumnName = "studio_id", unique = true)
    private Studio studio;
}
