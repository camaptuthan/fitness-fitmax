package fivemonkey.com.fitnessbackend.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StatusDTO {

    private Long id;

    private String type;

    private int type_id;

    private String statusName;
}
