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



    private String newStudioName;

    private String newStudioId;

    private Date date;


    private String userStudioName;

    private String userStudioId;

    private String userEmail;

}
