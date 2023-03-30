package fivemonkey.com.fitnessbackend.dto;

import fivemonkey.com.fitnessbackend.entities.Tracking;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TraineeDTO {

    private String email;

    private Double height;

    private Double weight;
    private Date date;

    private String studioSwitch;

    private String citySwitch;

    private String serviceSwitch;
    private int status;

    private String userStudioName;

    private String userStudioId;

    private String userAvatar;

    private String userLastName;
    private String userFirstName;

    private String userCityName;
}
