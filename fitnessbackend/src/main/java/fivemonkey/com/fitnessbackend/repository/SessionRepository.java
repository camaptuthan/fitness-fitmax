package fivemonkey.com.fitnessbackend.repository;

import fivemonkey.com.fitnessbackend.entities.Schedule;
import fivemonkey.com.fitnessbackend.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, String> {

    @Query("select s from Session s where s.schedule.id = ?1")
    List<Session> getSessionsBySchedule(String scheduleId);

    @Query("select s from Session s where s.schedule.id = ?1 and s.happenedDate between ?2 and ?3")
    List<Session> getSessionsByScheduleAndHappenedDateBetween(String schedule, Date happenedDate, Date happenedDate2);
}
