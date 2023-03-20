package fivemonkey.com.fitnessbackend.entities;

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
public class Slider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slider_id")
    private Long id;

    @Column(name = "image")
    private String image;

    @Column(name = "description", columnDefinition = "text")
    private String des;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date date;

    //user-slider relationship
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Column(name="title")
    private String title;



}
