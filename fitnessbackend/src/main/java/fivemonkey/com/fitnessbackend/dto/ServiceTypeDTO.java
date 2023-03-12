package fivemonkey.com.fitnessbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ServiceTypeDTO {

    private Long id;

    private String image;

    private String type;

    private List<ServiceDTO> serviceDTOList;
}
