package fivemonkey.com.fitnessbackend.dto;

import fivemonkey.com.fitnessbackend.entities.Blog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDTO {

    private String id;

    private String name;

    private String des;

    private String type;

}
