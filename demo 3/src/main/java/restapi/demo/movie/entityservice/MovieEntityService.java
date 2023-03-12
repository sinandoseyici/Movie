package restapi.demo.movie.entityservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restapi.demo.movie.dao.MovieDao;
import restapi.demo.movie.entity.Movie;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieEntityService {

    private final MovieDao movieDao;

    public List<Movie> findAll(){
        return movieDao.findAll();
    }

    public Optional<Movie> findById(Long id){
        return movieDao.findById(id);
    }

    public Movie save(Movie movie){
        return movieDao.save(movie);
    }

    public void delete(Movie movie){
        movieDao.delete(movie);
    }

    public void deleteById(Long id){
        movieDao.deleteById(id);
    }

    public boolean isExist(Long id){
        return movieDao.existsById(id);
    }

}
