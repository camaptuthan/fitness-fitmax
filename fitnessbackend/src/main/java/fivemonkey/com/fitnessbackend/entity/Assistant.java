package fivemonkey.com.fitnessbackend.entity;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
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

    //assistant-user relationship
    @OneToOne
    @MapsId
    @JoinColumn(name = "assistant_email")
    private User user;
}


