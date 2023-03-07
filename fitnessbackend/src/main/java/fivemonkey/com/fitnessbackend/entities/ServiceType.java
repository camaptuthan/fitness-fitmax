package fivemonkey.com.fitnessbackend.entities;

import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "service_type", schema = "dbo")
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private Long id;

    @Column(name = "description", columnDefinition = "text")
    private String type;

    @Column(name = "image", columnDefinition = "mediumblob")
    private byte[] image;

    //service-serviceDetail relationship
    @OneToMany(mappedBy = "serviceType")
    private List<Services> services;
}
