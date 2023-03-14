package fivemonkey.com.fitnessbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "[user]", schema = "dbo")
public class User {

    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    @NotEmpty(message = "This field can not empty")
    @Length(min = 8, message = "Password must be at least 8 characters")
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
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;
    //studio-user relationship
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "studio_id", referencedColumnName = "studio_id")
    private Studio studio;

    //user-blog relationship
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Blog> blogs;

    //user-studioManager relationship
    @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private StudioManager studioManager;

    //assistant-user relationship
    @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Assistant assistant;

    //trainee-user relationship
    @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Trainee trainee;

    //trainer-user relationship
    @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Trainer trainer;

    //cityManager-user relationship
    @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private CityManager cityManager;

    @Column(name = "verification_code", updatable = false)
    private String verificationCode;

    public User(String userEmail) {
        this.email = userEmail;
    }
}
