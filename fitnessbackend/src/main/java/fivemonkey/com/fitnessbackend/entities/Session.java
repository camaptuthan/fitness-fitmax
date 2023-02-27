package fivemonkey.com.fitnessbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "session", schema = "dbo",  uniqueConstraints = {@UniqueConstraint(columnNames = {"happened_date","schedule_id"})})

public class Session {

    @Id
    @GeneratedValue(generator = "session_generator")
    @GenericGenerator(name = "session_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.SessionIdentifier")
    @Column(name = "session_id")
    private String id;

    @Column(name = "session_name")
    private String name;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", referencedColumnName = "schedule_id")

    @JsonIgnore
    private Schedule schedule;

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
