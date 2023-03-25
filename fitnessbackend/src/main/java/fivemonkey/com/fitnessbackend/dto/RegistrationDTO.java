package fivemonkey.com.fitnessbackend.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegistrationDTO {
    private String id;
    private String date;
    private Date startDate;
    private boolean status;
    private String servicesId;
    private String servicesName;
    private String path;
    private String traineeEmail;

}
