package main.controllers;

import main.entites.Writer;
import main.exceptions.NotFoundException;
import main.repositories.WriterRepository;
import main.services.IWriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/writer")
@CrossOrigin("http://localhost:3000")
public class WriterController {

    private WriterRepository writerRepository;

    @Autowired
    private IWriterService writerService;

    public WriterController(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    @PostMapping
    public Writer saveWriter(@RequestBody Writer writer) {
        return writerRepository.save(writer);
    }

    @GetMapping
    public List<Writer> findAllWriters() {
        return writerRepository.findAll();
    }

    @GetMapping("/{writerId}")
    public Writer findWriter(@PathVariable Integer writerId) {
        return writerRepository.findById(writerId).orElseThrow(() -> new NotFoundException(writerId));
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public void deleteWriter(@PathVariable("id") Integer id) {
        writerRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Writer updateWriter(@PathVariable("id") int id, @RequestBody Writer writer) {
        return writerService.updateWriter(id,writer);
    }
    @GetMapping("/lastName")
    public ResponseEntity<List<Writer>> getWriterByLastName(@RequestParam String lastName) {
        return new ResponseEntity<List<Writer>>(writerRepository.findByLastName(lastName), HttpStatus.OK);
    }

}



