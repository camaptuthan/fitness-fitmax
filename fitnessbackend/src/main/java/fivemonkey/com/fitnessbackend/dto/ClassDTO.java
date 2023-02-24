package fivemonkey.com.fitnessbackend.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

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

     private List<ScheduleDTO> scheduleDTO;

     @Override
     public String toString() {
          return "ClassDTO{" +
                  "id=" + id +
                  ", name='" + name + '\'' +
                  ", date=" + date +
                  ", price=" + price +
                  ", img='" + img + '\'' +
                  '}';
     }
}
