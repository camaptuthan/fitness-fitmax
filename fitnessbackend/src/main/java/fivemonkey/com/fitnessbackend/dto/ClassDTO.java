package fivemonkey.com.fitnessbackend.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClassDTO {
     private Long id;
     private String name;
     private Date date;

     private Float price;

//     private Services services;
     private String img;

}
