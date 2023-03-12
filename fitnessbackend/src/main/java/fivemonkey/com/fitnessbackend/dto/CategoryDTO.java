package fivemonkey.com.fitnessbackend.dto;


import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDTO {

    private String id;

    private String name;

    private String des;

    private String type;

    private List<ServicesDTO> serviceDTOList;
}
