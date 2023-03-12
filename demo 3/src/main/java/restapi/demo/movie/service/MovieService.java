package restapi.demo.movie.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restapi.demo.movie.converter.MovieMapper;
import restapi.demo.movie.dao.MovieDao;
import restapi.demo.movie.dto.MovieDto;
import restapi.demo.movie.dto.MovieSaveRequestDto;
import restapi.demo.movie.dto.MovieUpdateRequestDto;
import restapi.demo.movie.entity.Movie;
import restapi.demo.movie.entityservice.MovieEntityService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieEntityService movieEntityService;

    public List<MovieDto> findAll(){
        List<Movie> movieList = movieEntityService.findAll();

        List<MovieDto> movieDtoList = MovieMapper.movieMapper.convertToMovieDtoList(movieList);

        return movieDtoList;
    }

    public MovieDto findById(Long id){
        Optional<Movie> optionalMovie = movieEntityService.findById(id);

        Movie movie = optionalMovie.get();

        MovieDto movieDto = MovieMapper.movieMapper.convertToMovieDto(movie);

        return movieDto;
    }

    public MovieDto save(MovieSaveRequestDto movieSaveRequestDto){

        Movie movie = MovieMapper.movieMapper.convertToMovie(movieSaveRequestDto);

        movie = movieEntityService.save(movie);

        MovieDto movieDto = MovieMapper.movieMapper.convertToMovieDto(movie);

        return movieDto;

    }

    public void deleteById(Long id){

        movieEntityService.deleteById(id);

    }

    public MovieDto update(MovieUpdateRequestDto movieUpdateRequestDto){

        boolean isExist = movieEntityService.isExist(movieUpdateRequestDto.getId());
        if (!isExist) {
            throw new RuntimeException("MOVIE DOES NOT EXIST !");
        }

        Movie movie = MovieMapper.movieMapper.convertToMovie(movieUpdateRequestDto);

        movie = movieEntityService.save(movie);

        MovieDto movieDto = MovieMapper.movieMapper.convertToMovieDto(movie);

        return movieDto;


    }
}
