package fivemonkey.com.fitnessbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SessionDTO {
    private Long id;
    private Date happenedDate;

    @Override
    public String toString() {
        return "SessionDTO{" +
                "id=" + id +
                ", happenedDate=" + happenedDate +

                '}';
    }
}
