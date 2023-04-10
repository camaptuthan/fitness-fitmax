package fivemonkey.com.fitnessbackend.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.entities.Trainer;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ClassDTO {

    private String id;
    private String name;
    private Date date;

    private Float price;

    private String servicesId;
    private String servicesName;
    private String img;

    private boolean status;
    private String des;
    private String duration;

    private String trainerId;

    private List<ScheduleDTO> scheduleDTO;

}
