package fivemonkey.com.fitnessbackend.dto;

import fivemonkey.com.fitnessbackend.entities.Role;
import fivemonkey.com.fitnessbackend.entities.Studio;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    @NotNull(message = "Required not null")
    private String email;
    @NotNull(message = "Required not null")
    private String password;
    @NotNull(message = "Required not null")
    private String firstName;
    @NotNull(message = "Required not null")
    private String lastName;
    private String address;
    private String avatar;
    private Date date;
    private boolean status;

    private String roleId;
    private String roleName;
    private String studioName;

    private  String studioId;
    private String phone;
    private String vericode;






}