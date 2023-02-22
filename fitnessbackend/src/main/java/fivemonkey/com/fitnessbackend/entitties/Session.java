package fivemonkey.com.fitnessbackend.entitties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "session", schema = "dbo")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Long id;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    //class-session relationship
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private Clazz aClass;

    //session-schedule relationship
    @OneToOne
    @JoinColumn(name = "schedule_id", referencedColumnName = "schedule_id", unique = true)
    private Schedule schedule;
}
