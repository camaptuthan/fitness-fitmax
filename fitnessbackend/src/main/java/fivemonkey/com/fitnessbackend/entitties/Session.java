package fivemonkey.com.fitnessbackend.entitties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "class_detail", schema = "dbo")
public class ClassDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_detail_id")
    private Long id;

    @Column(name = "description", columnDefinition = "MEDIUMTEXT")
    private String description;

    
}
