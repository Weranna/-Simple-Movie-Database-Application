package main.services;

import main.entites.Director;
import main.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorService implements IDirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public Director updateDirector(int id, Director director) {
        director.setId(id);
        return directorRepository.save(director);
    }

}
