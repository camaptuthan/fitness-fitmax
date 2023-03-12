package fivemonkey.com.fitnessbackend.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginDTO {

    @NotEmpty( message = "Username is required!")
    private String username;

    @NotEmpty(message = "Password is required!")
    private String password;

}
