package fivemonkey.com.fitnessbackend.dto;


import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ClassDTO {

    private Long id;

    private Date servicesDate;

    private Float servicesPrice;

    private String servicesId;

    private String servicesName;

    private String servicesImage;

    private int servicesStatus;

    private String servicesDes;

    private String servicesDuration;

    private Long servicesCategoryId;

    private String servicesCategoryName;

    private String servicesCityName;

    private Long servicesCityId;

    private String servicesStudioId;

    private int servicesStatusType_id;

    private String servicesStatusStatus;

    private String trainerName;

//    public String getTrainerName() {
//        if (sessions.isEmpty()) {
//            return "Not assigned yet!";
//        }
//        return sessions.get(0).getTrainer().getUserFirstName() + " " + sessions.get(0).getTrainer().getUserLastName();
//    }

    private List<SessionDTO> sessions;


}
