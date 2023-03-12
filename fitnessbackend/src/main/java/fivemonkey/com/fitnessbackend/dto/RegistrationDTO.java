package fivemonkey.com.fitnessbackend.dto;

import fivemonkey.com.fitnessbackend.entities.Services;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {
    private String id;
    private String date;
    private String startDate;
    private boolean status;
    private String servicesId;
    private String servicesName;
    private String traineeEmail;

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", startDate='" + startDate + '\'' +
                ", status=" + status +
                ", serviceId='" +  servicesId + '\'' +
                ", traineeEmail='" + traineeEmail + '\'' +
                '}';
    }
}
