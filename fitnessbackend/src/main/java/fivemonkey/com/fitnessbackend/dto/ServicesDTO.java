package fivemonkey.com.fitnessbackend.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServicesDTO {

    private String id;

    private String name;

    private boolean status;

    private Date date;

    private StudioDTO studioDTO;

    private String categoryId;

    private String serviceTypeId;

    private Long cityId;

    private List<RegistrationDTO> registrationDTOS;


}
