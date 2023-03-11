package fivemonkey.com.fitnessbackend.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonalTrainingDTO {
    private String id;
    private String name;
    private String image;
    private int slot;
    private Float price;
    private int duration;
    private String des;
    private String date;
    private boolean status;
    private String servicesId;
    private String servicesName;
    private String trainerEmail;
    private String trainerName;

}
