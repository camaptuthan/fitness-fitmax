package fivemonkey.com.fitnessbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "schedule", schema = "dbo")
public class Schedule {

    @Id
    @GeneratedValue(generator = "schedule_generator")
    @GenericGenerator(name = "schedule_generator", strategy = "fivemonkey.com.fitnessbackend.identifier.ScheduleIdentifier")
    @Column(name = "schedule_id")
    private String id;

    @Temporal(TemporalType.TIME)
    @Column(name = "start_time")
    private Date startTime;

    @Temporal(TemporalType.TIME)
    @Column(name = "end_time")
    private Date endTime;

    @OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Session> sessions;

//    @Override
//    public String toString() {
//        return "Schedule{" +
//                "id=" + id +
//                ", startTime=" + startTime +
//                ", endTime=" + endTime +
//                ", createdDate=" + createdDate +
//                ", sessions=" + sessions +
//                '}';
//    }
}
