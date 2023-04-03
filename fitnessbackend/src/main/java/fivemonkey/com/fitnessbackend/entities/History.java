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
@Table(name = "[history]", schema = "dbo")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Long id;

    @Column(name = "city_old")
    private String oldCity;

    @Column(name = "city_new")
    private String newCity;

    @Min(value = 1, message = "{Size.Field.Price}")
    @Column(name = "price_new")
    private Float newPrice;

    @Min(value = 1, message = "{Size.Field.Price}")
    @Column(name = "price_old")
    private Float oldPrice;

    @Column(name = "package_old")
    private String oldPackage;

    @Column(name = "package_new")
    private String newPackage;

    @Column(name = "studio_old")
    private String oldStudio;
    @Column(name = "studio_new")
    private String newStudio;


    @Column(name = "created_date")
    private Date date;



    //trainee-history relationship
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "trainee_email", referencedColumnName = "trainee_email", nullable = false)
    private Trainee trainee;

}
