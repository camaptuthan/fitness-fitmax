package fivemonkey.com.fitnessbackend.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String avatar;
    private Date date;
    private boolean status;

    private String roleId;
    private String roleName;
    private String studioName;

    private String studioId;
    private String vericode;


}