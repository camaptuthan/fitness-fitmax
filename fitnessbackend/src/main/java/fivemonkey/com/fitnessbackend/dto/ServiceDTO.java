package fivemonkey.com.fitnessbackend.dto;

import fivemonkey.com.fitnessbackend.entities.Category;
import fivemonkey.com.fitnessbackend.entities.Studio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ServiceDTO {

    private String id;

    private String name;

    private boolean status;

    private Date date;

    private StudioDTO studioDTO;

    private CategoryDTO category;

    private ServiceTypeDTO serviceTypeDTO;

    private List<RegistrationDTO> registrationDTOS;
}
