package fivemonkey.com.fitnessbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "request", schema = "dbo")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date date;

    @Min(value = 0)
    @Max(value = 4)
    @Column(name = "request_type")
    private int type;

    @OneToOne(mappedBy = "request",cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Registration registration;

    @Column(name = "new_service_id")
    private String newService;

    @Column(name = "new_trainer_id")
    private Long newTrainer;

    @Column(name = "new_studio_id")
    private String newStudio;

    @Column(name = "new_city_id")
    private Long newCity;

    @Column(name = "new_price")
    private Float newPrice;

    @Min(value = 0)
    @Max(value = 2)
    @Column(name = "request_status")
    private int status;

    @Column(name = "approved_by")
    private Long approved_by;

    //request-history relationship
    @OneToMany(mappedBy = "request", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<History> histories;
}
