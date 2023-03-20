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

    private String image;

    private String des;

    private int duration;

    private Float price;

    private int status;

    private Date date;

    private String studioId;

    private Long categoryId;

    private Long serviceTypeId;

    private Long cityId;


}
