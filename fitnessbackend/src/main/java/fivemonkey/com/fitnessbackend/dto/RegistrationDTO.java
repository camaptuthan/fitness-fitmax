package fivemonkey.com.fitnessbackend.dto;

import io.grpc.internal.JsonUtil;
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
    private int status;
    private String servicesId;
    private String servicesName;
    private String servicesType;
    private String servicesDescription;
    private String servicesDuration;
    private String servicesPrice;
    private String servicesImage;
    private String servicesStatus;
    private String servicesStudioId;
    private String servicesStudioName;
    private String servicesStudioAddress;
    private String servicesStudioCity;
    private String servicesStudioStatus;
    private String path;
    private String traineeEmail;
    private String traineeName;
    private String traineePhone;
    private String traineeGender;
    private String traineeAge;
    private String traineeWeight;
    private String traineeHeight;
    private String traineeStatus;
    private String traineeImage;
    private String traineeAddress;
    private String trainerEmail;

}

