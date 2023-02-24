package fivemonkey.com.fitnessbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "session", schema = "dbo")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Long id;

    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Temporal(TemporalType.DATE)
    @Column(name = "happened_date")
    private Date happenedDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date createdDate;

    //class-session relationship
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    @JsonIgnore
    private Clazz aClass;

    //session-schedule relationship


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "session_schedule",
            joinColumns = { @JoinColumn(name = "session_id") },
            inverseJoinColumns = {@JoinColumn(name = "schedule_id") })
    @JsonIgnore
    private List<Schedule> schedules;

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", happenedDate=" + happenedDate +
                ", createdDate=" + createdDate +

                '}';
    }
}
