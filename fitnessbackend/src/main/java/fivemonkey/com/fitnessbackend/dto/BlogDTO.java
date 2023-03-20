package fivemonkey.com.fitnessbackend.dto;

import fivemonkey.com.fitnessbackend.entities.Category;
import fivemonkey.com.fitnessbackend.entities.User;
import lombok.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BlogDTO {

    private Long id;

    private String title;

    private String thumbnail;

    private String description;

    private Date date;

    private int status;

    private Category category;

    private User user;


}
