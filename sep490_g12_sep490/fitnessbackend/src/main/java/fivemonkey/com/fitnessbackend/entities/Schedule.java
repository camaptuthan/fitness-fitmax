package fivemonkey.com.fitnessbackend.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
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


    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date createdDate;


    @OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Session> sessions;

}
