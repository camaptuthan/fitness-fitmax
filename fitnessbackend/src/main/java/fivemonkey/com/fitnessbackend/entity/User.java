package fivemonkey.com.fitnessbackend.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user",schema = "dbo")
public class User {

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "avatar")
    private String avatar;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date date;

    @Column(name = "status", columnDefinition = "BOOLEAN")
    private boolean status;

    //role-user relationship
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;

    //studio-user relationship
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studio_id", referencedColumnName = "studio_id")
    private Studio studio;

    //user-blog relationship
    @OneToMany(mappedBy = "user")
    private List<Blog> blogs;

    //user-registration relationship
    @OneToMany(mappedBy = "user")
    private List<Registration> registrations;

    //user-user(manager) relationship
    @OneToMany(mappedBy = "user")
    private List<User> users;

    @ManyToOne
    @JoinColumn(name = "managed_by", referencedColumnName = "email")
    private User user;
}
