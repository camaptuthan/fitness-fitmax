package fivemonkey.com.fitnessbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SessionDTO {
    private String id;
    private String weekDay;

    private String name;
    private String classId;

    @Override
    public String toString() {
        return "SessionDTO{" +
                "id=" + id +


                '}';
    }
}
