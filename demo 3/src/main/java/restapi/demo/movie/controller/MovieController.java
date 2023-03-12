package restapi.demo.movie.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import restapi.demo.movie.dto.MovieDto;
import restapi.demo.movie.dto.MovieSaveRequestDto;
import restapi.demo.movie.dto.MovieUpdateRequestDto;
import restapi.demo.movie.service.MovieService;
import restapi.demo.generic.response.RestResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity findAll(){

        List<MovieDto> movieDtoList = movieService.findAll();

        return ResponseEntity.ok(RestResponse.of(movieDtoList));
    }


    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        MovieDto movieDto = movieService.findById(id);

        return ResponseEntity.ok(RestResponse.of(movieDto));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Validated MovieSaveRequestDto movieSaveRequestDto){

        MovieDto movieDto = movieService.save(movieSaveRequestDto);

        return ResponseEntity.ok(RestResponse.of(movieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(Long id){

        movieService.deleteById(id);

        return ResponseEntity.ok(RestResponse.isEmpty());
    }

    @PutMapping
    public ResponseEntity update(@RequestBody MovieUpdateRequestDto movieUpdateRequestDto){

        MovieDto movieDto = movieService.update(movieUpdateRequestDto);

        return ResponseEntity.ok(RestResponse.of(movieDto));

    }

}
