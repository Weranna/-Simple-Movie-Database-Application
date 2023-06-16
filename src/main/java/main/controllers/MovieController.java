package main.controllers;

import main.entites.Movie;
import main.exceptions.NotFoundException;
import main.repositories.MovieRepository;
import main.services.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin("http://localhost:3000")
public class MovieController {

    private MovieRepository movieRepository;
    @Autowired
    private IMovieService movieService;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie saveMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public void deleteMovie(@PathVariable("id") int id) {
        movieRepository.deleteById(id);
    }

    @GetMapping
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping(value = "/{movieId}")
    public Movie findMovie(@PathVariable int movieId) {
        return movieRepository.findById(movieId).orElseThrow(() -> new NotFoundException(movieId));
    }

    @GetMapping("/{pageNo}/{pageSize}")
    public List<Movie> getPaginated(@PathVariable int pageNo,@PathVariable int pageSize) {
        return movieService.findPaginated(pageNo,pageSize);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable("id") int id, @RequestBody Movie movie) {
        return movieService.updateMovie(id,movie);
    }

    @GetMapping("/title")
    public ResponseEntity<List<Movie>> getMovieByTitle(@RequestParam String title) {
        return new ResponseEntity<List<Movie>>(movieRepository.findByTitle(title), HttpStatus.OK);
    }

}

