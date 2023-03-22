package fivemonkey.com.fitnessbackend.repository;
import fivemonkey.com.fitnessbackend.entities.Slider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SliderRepository extends JpaRepository<Slider, Long> {

}
