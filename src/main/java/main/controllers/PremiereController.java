package main.controllers;

import main.entites.Premiere;
import main.exceptions.NotFoundException;
import main.repositories.PremiereRepository;
import main.services.IPremiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/premiere")
@CrossOrigin("http://localhost:3000")
public class PremiereController {

    private PremiereRepository premiereRepository;

    @Autowired
    private IPremiereService premiereService;

    public PremiereController(PremiereRepository premiereRepository) {
        this.premiereRepository = premiereRepository;
    }

    @PostMapping
    public Premiere savePremiere(@RequestBody Premiere premiere) {
        return premiereRepository.save(premiere);
    }

    @GetMapping
    public List<Premiere> findAllPremieres() {
        return premiereRepository.findAll();
    }

    @GetMapping("/{premiereId}")
    public Premiere findPremiere(@PathVariable int premiereId) {
        return premiereRepository.findById(premiereId).orElseThrow(() -> new NotFoundException(premiereId));
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public void deletePremiere(@PathVariable("id") int id) {
        premiereRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Premiere updatePremiere(@PathVariable("id") int id, @RequestBody Premiere premiere) {
        return premiereService.updatePremiere(id,premiere);
    }

}

