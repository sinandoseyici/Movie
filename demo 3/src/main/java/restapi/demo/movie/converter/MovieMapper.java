package restapi.demo.movie.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import restapi.demo.movie.dto.MovieDto;
import restapi.demo.movie.dto.MovieSaveRequestDto;
import restapi.demo.movie.dto.MovieUpdateRequestDto;
import restapi.demo.movie.entity.Movie;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieMapper {

    MovieMapper movieMapper = Mappers.getMapper(MovieMapper.class);

    MovieDto convertToMovieDto(Movie movie);

    List<MovieDto> convertToMovieDtoList(List<Movie> movieList);

    Movie convertToMovie(MovieSaveRequestDto movieSaveRequestDto);

    Movie convertToMovie(MovieUpdateRequestDto movieUpdateRequestDto);

}
