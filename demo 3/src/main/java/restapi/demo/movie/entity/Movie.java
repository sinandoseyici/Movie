package restapi.demo.movie.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "MOVIE")
public class Movie {

    @Id
    @SequenceGenerator(name = "Movie", sequenceName = "MOVIE_ID_SEQ")
    @GeneratedValue(generator = "Movie")
    private Long id;

    @Column(name = "TITLE", length = 100)
    private String title;

    @Column(name = "OVERVIEW", length = 100)
    private String overview;

}
