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
@Table(name = "[user]",schema = "dbo")
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

    @Column(name = "status", nullable = false)
    private boolean status;

    //role-user relationship
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;

    //studio-user relationship
    @ManyToOne
    @JoinColumn(name = "studio_id", referencedColumnName = "studio_id")
    private Studio studio;

    //user-blog relationship
    @OneToMany(mappedBy = "user")
    private List<Blog> blogs;

    //user-manager relationship
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Manager manager;

    //assistant-user relationship
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Assistant assistant;

    //trainee-user relationship
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Trainee trainee;

    //trainer-user relationship
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Trainer trainer;

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", avatar='" + avatar + '\'' +
                ", date=" + date +
                ", status=" + status +
                ", role=" + role +
                ", studio=" + studio +
                ", blogs=" + blogs +
                ", manager=" + manager +
                ", assistant=" + assistant +
                ", trainee=" + trainee +
                ", trainer=" + trainer +
                '}';
    }
}
