package fivemonkey.com.fitnessbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScheduleDTO {
    private Long id;

    private String startTime;

    private String endTime;

    private List<SessionDTO> sessionDTOs;

}
