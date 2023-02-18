package fivemonkey.com.fitnessbackend.entitties;

import javax.persistence.*;

@Entity
@Table(name = "category_service", schema = "dbo")
public class CategoryService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    private Services service;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;
}
