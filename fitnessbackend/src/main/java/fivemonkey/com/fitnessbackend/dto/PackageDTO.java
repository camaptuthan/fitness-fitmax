package fivemonkey.com.fitnessbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    private ServiceDTO serviceDTO;

    public PackageDTO(String name, int duration, Float price, String des, boolean status) {
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.des = des;
        this.status = status;
    }

    @Override
    public String toString() {
        return "PackageDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                ", des='" + des + '\'' +
                ", status=" + status +
                ", serviceDTO=" + serviceDTO +
                '}';
    }
}
