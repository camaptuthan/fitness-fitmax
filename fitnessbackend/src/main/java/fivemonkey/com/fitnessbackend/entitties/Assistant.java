package fivemonkey.com.fitnessbackend.entitties;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "assistant", schema = "dbo")
public class Assistant {

    @Id
    @Column(name = "assistant_email")
    private String email;

    //assistant-service relationship
    @OneToMany(mappedBy = "assistant")
    private List<Services> services;

    //assistant-role relationship
    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", unique = true)
    private Role role;
}


