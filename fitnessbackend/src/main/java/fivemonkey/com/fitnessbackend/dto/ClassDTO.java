package fivemonkey.com.fitnessbackend.dto;


import fivemonkey.com.fitnessbackend.entities.Services;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ClassDTO {

    private String id;
    private String name;
    private Date date;

    private Float price;

    private String servicesId;
    private String servicesName;

//    private Services service;
    private String img;

    private boolean status;
    private String des;
    private String duration;

    private String trainerId;

    private List<SessionDTO> sessions;
}
