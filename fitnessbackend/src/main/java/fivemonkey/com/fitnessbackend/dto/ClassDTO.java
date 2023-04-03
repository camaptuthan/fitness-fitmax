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

    private Date servicesUpdatedDate;

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

    private String servicesStudioName;

    private int servicesStatusType_id;

    private String servicesStatusStatus;

    private String trainerName;

    private List<SessionDTO> sessions;


}
