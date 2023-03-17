package fivemonkey.com.fitnessbackend.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "setting", schema = "dbo")
public class Setting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "type", referencedColumnName = "id", nullable = true)
    private Setting type;
    private String name;
    @OneToMany(mappedBy = "type", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Set<Setting> subordinates = new HashSet<>();

}
