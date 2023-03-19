package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.TrackingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingDetailRepository extends JpaRepository<TrackingDetail, Long> {
}
