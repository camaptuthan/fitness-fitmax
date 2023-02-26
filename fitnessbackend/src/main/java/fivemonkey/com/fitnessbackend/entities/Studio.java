package fivemonkey.com.fitnessbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "studio", schema = "dbo")
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studio_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "contact")
    private String contact;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date date;

    @Column(name = "description", columnDefinition = "text")
    private String des;

    @Column(name = "status", nullable = false)
    private boolean status;

    //studio-user relationship
    @OneToMany(mappedBy = "studio")
    private List<User> users;

    //studio-service relationship
    @OneToMany(mappedBy = "studio")
    private List<Services> services;

    //studio-manager relationship
    @OneToOne
    @JoinColumn(name = "manager_email", referencedColumnName = "manager_email", unique = true)
    private Manager manager;

    @Override
    public String toString() {
        return "Studio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", contact='" + contact + '\'' +
                ", date=" + date +
                ", des='" + des + '\'' +
                ", status=" + status +
                ", users=" + users +
                ", services=" + services +
                ", manager=" + manager +
                '}';
    }
}
