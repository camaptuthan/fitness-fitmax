package fivemonkey.com.fitnessbackend.dto;

import fivemonkey.com.fitnessbackend.entities.Role;
import fivemonkey.com.fitnessbackend.entities.Studio;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String avatar;
    private Date date;
    private boolean status;

    private String roleId;
    private String roleName;
    private String studioName;

    private  String studioId;
    private String phone,vericode;




}