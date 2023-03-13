package fivemonkey.com.fitnessbackend.dto;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudioDTO {
    private String id;
    private String name;
    private String city;

    private String district;

    private String contact;

    private Date date;

    private String des;

    private boolean status;

    private String managerEmail;
}
