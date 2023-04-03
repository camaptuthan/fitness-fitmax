package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    @Query("select h from History h WHERE h.status = 1 and h.newCity= ?1 and h.newPackage = ?2")
    History getHistoriesById (String cityName, String packageId);
}
