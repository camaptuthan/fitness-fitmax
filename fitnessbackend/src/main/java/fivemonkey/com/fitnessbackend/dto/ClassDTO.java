package fivemonkey.com.fitnessbackend.dto;


import lombok.*;

import java.util.Date;
import java.util.List;

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
