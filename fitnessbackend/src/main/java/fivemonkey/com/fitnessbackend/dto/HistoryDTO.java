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


    private String oldCity;


    private String newCity;


    private Float newPrice;


    private Float oldPrice;


    private String oldPackage;


    private String newPackage;


    private String oldStudio;

    private String newStudio;


    private Date date;


    private Date traineeDate;


    private int traineeStatusSw;

}
