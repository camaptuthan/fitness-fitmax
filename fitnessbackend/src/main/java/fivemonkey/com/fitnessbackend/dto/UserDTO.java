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

    private Long roleId;
    private String roleName;
    private String studioName;

    private  Long studioId;

    @Override
    public String toString() {
        return "UserDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", avatar='" + avatar + '\'' +
                ", date=" + date +
                ", status=" + status +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", studioName='" + studioName + '\'' +
                ", studioId=" + studioId +
                '}';
    }
}