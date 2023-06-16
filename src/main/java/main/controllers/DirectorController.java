package main.controllers;

import main.entites.Director;
import main.repositories.DirectorRepository;
import main.services.IDirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/director")
@CrossOrigin("http://localhost:3000")
public class DirectorController {
    private DirectorRepository directorRepository;

    @Autowired
    private IDirectorService directorService;

    public DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @GetMapping
    public List<Director> findAllDirectors() {
        return directorRepository.findAll();
    }

    @PostMapping
    public Director saveDirector(@RequestBody Director director) {
        return directorRepository.save(director);
    }

    @GetMapping("/{id}")
    public Optional<Director> findDirector(@PathVariable Integer id) {
        return directorRepository.findById(id);
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public void deleteDirector(@PathVariable("id") Integer id) {
        directorRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Director updateDirector(@PathVariable("id") int id, @RequestBody Director director) {
        return directorService.updateDirector(id,director);
    }

    @GetMapping("/lastName")
    public ResponseEntity<List<Director>> getDirectorByLastName(@RequestParam String lastName) {
        return new ResponseEntity<List<Director>>(directorRepository.findByLastName(lastName), HttpStatus.OK);
    }

}

