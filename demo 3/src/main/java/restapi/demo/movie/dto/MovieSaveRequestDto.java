package restapi.demo.movie.dto;

import lombok.Data;

@Data
public class MovieSaveRequestDto {

    private Long id;
    private String title;
    private String overview;
}
