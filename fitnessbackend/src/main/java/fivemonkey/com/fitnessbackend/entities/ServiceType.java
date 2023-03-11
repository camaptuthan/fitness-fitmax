package fivemonkey.com.fitnessbackend.entities;

import jdk.dynalink.linker.LinkerServices;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "service_type", schema = "dbo")
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private Long id;

    @Column(name = "description", columnDefinition = "text")
    private String type;

    @Column(name = "image")
    private String image;

    //service-serviceDetail relationship
    @OneToMany(mappedBy = "serviceType", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Services> services;
}
