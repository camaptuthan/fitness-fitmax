package fivemonkey.com.fitnessbackend.dto;

import fivemonkey.com.fitnessbackend.entities.Role;
import fivemonkey.com.fitnessbackend.entities.Studio;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

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
    private String phone;
    private String avatar;
    private Date date;
    private boolean status;

    private String roleId;
    private String roleName;
    private String studioName;

    private String studioId;

    @Override
    public String toString() {
        return "UserDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", avatar='" + avatar + '\'' +
                ", date=" + date +
                ", status=" + status +
                ", roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", studioName='" + studioName + '\'' +
                ", studioId='" + studioId + '\'' +
                '}';
    }

    private String vericode;


}