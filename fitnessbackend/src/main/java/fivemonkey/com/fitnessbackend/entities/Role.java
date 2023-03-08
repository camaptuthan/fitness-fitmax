package fivemonkey.com.fitnessbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "role", schema = "dbo")
public class Role {

    @Id
    @GeneratedValue(generator = "role_generator")
    @GenericGenerator(name = "role_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.RoleIdentifier")
    @Column(name = "role_id")
    private String id;

    @Column(name = "role_name")
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String des;

    //role-user relationship
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", des='" + des + '\'' +
                ", users=" + users +
                '}';
    }
}
