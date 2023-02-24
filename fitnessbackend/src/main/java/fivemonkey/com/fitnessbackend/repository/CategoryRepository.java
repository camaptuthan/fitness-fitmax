package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
