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
@Table(name = "service_detail", schema = "dbo")
public class ServiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_detail_id")
    private Long id;

    @Column(name = "description", columnDefinition = "text")
    private String des;

    //service-serviceDetail relationship
    @OneToMany(mappedBy = "serviceDetail")
    private List<Services> services;
}
