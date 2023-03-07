package fivemonkey.com.fitnessbackend.dto;

import fivemonkey.com.fitnessbackend.entities.Category;
import fivemonkey.com.fitnessbackend.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BlogDTO {

    private String id;

    private String title;

    private byte[] image;

    private String des;

    private Date created_date;

    private boolean status;

    private Category category;

    private User writer_email;

    @Override
    public String toString() {
        return "BlogDTO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", image=" + Arrays.toString(image) +
                ", des='" + des + '\'' +
                ", created_date=" + created_date +
                ", status=" + status +
                ", category=" + category +
                ", writer_email='" + writer_email + '\'' +
                '}';
    }
}
