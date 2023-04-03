package fivemonkey.com.fitnessbackend.dto;

import fivemonkey.com.fitnessbackend.entities.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HistoryDTO {

    private Long id;

    private String traineeEmail;

    private String traineeUserStudioName;

    private String traineeStudioSwitch;

    private Date traineeDate;

    private Date date;

    private String traineeUserCityName;

    private String traineeCitySwitch;

    private String traineeServiceSwitch;

    private  String traineeUserServiceName;

    private int traineeStatusSw;

}
