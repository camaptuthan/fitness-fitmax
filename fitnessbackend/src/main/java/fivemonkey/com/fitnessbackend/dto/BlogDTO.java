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

    private String id;

    private String title;

    private String thumbnail;

    private String description;

    private Date date;

    private boolean status;

    private Category category;

    private String userEmail;
    private User user;


}
