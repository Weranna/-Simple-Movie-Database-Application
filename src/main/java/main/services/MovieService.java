package main.services;

import main.entites.Movie;
import main.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> findPaginated(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize) ;
        Page<Movie> pagedResult = movieRepository.findAll(paging);
        return pagedResult.toList();
    }

    @Override
    public Movie updateMovie(int id, Movie movie) {
        movie.setId(id);
        return movieRepository.save(movie);
    }

}
