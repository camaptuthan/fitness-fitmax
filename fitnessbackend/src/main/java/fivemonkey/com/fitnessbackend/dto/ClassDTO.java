package fivemonkey.com.fitnessbackend.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import fivemonkey.com.fitnessbackend.entities.Services;
import fivemonkey.com.fitnessbackend.entities.Trainer;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

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



    @JsonIgnore
    private Services service;
    private String img;

     private int slot;


    private boolean status;
    private String des, duration;
    @JsonIgnore
    private Trainer trainer;


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
