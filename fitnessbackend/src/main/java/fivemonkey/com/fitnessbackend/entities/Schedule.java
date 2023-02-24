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
@Table(name = "schedule", schema = "dbo")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    @Column(name = "start_time")
    private Date startTime;


    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "created_date")
    private Date createdDate;

    @OneToMany(mappedBy = "schedule",fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
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
