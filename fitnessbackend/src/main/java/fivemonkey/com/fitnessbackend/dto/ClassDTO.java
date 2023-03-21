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
    private String servicesImg;
    private int servicesStatus;
    private String servicesDes;
    private String servicesDuration;
    private String servicesStudioId;
    private String trainerId;
    private List<SessionDTO> sessions;
}
