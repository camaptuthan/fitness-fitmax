package fivemonkey.com.fitnessbackend.dto;

import fivemonkey.com.fitnessbackend.entities.Services;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegistrationDTO {
    private String id;
    private String date;
    private String startDate;
    private boolean status;
    private String servicesId;
    private String servicesName;
    private String traineeEmail;


}
