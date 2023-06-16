package main.services;

import main.entites.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMovieService {
    List<Movie> findPaginated(int pageNo, int pageSize);

    Movie updateMovie(int id, Movie movie);
}
