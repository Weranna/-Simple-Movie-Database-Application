package main.controllers;

import main.entites.Cinema;
import main.exceptions.NotFoundException;
import main.repositories.CinemaRepository;
import main.services.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinema")
@CrossOrigin("http://localhost:3000")
public class CinemaController {

    private CinemaRepository cinemaRepository;

    @Autowired
    private ICinemaService cinemaService;

    public CinemaController(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @PostMapping
    public Cinema saveCinema(@RequestBody Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @GetMapping
    public List<Cinema> findAllCinemas() {
        return cinemaRepository.findAll();
    }

    @GetMapping("/{cinemaId}")
    public Cinema findCinema(@PathVariable int cinemaId) {
        return cinemaRepository.findById(cinemaId).orElseThrow(() -> new NotFoundException(cinemaId));
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public void deleteCinema(@PathVariable("id") int id) {
        cinemaRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Cinema updateCinema(@PathVariable("id") int id, @RequestBody Cinema cinema) {
        return cinemaService.updateCinema(id,cinema);
    }

}

