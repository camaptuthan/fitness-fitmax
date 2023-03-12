package fivemonkey.com.fitnessbackend.dto;

import java.util.Date;
import java.util.List;

public class ServicesDTO {

    private String id;

    private String name;

    private boolean status;

    private Date date;

    private StudioDTO studioDTO;

    private CategoryDTO category;

    private ServiceTypeDTO serviceTypeDTO;

    private List<RegistrationDTO> registrationDTOS;
}
