package fivemonkey.com.fitnessbackend.dto;

import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.entities.Trainer;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClassDTO {
     private String id;
     private String name;
     private Date date;

     private Float price;

     private Services services;
     private String img;

     private boolean status;
     private String des,duration;

     private Trainer trainer;



}
