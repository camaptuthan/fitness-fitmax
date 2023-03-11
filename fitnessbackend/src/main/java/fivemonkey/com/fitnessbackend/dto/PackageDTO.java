package fivemonkey.com.fitnessbackend.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PackageDTO {
    private String id;

    @NotEmpty(message = "{Size.Field.Name}")
    @NotNull(message = "LastName can not be null!!")
    @NotEmpty(message = "LastName can not be empty!!")
    private String name;

    private String image;

    @Min(value = 1, message = "{Size.Field.Duration}")
    private int duration;

    @Min(value = 1, message = "{Size.Field.Price}")
    private Float price;
    private String des;
    private boolean status;

    public PackageDTO(String name, int duration, Float price, String des, boolean status) {
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.des = des;
        this.status = status;
    }


}
