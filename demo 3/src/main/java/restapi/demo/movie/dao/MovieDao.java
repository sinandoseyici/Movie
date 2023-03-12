package restapi.demo.movie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import restapi.demo.movie.entity.Movie;

public interface MovieDao extends JpaRepository<Movie, Long> {
}
