package fivemonkey.com.fitnessbackend.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TrainerDTO {
    private String email;
    private String userAvatar;
    private String userLastName;
    private String userFirstName;
    private String certi;
    private String description;
    private String qualification;

    private String userStudioName;
    private String specialication;


    private String achievement;


    private String philosophy;

    private String experience;


    private boolean status;
}
