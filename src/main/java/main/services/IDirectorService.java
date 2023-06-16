package main.services;

import main.entites.Director;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDirectorService {
    Director updateDirector(int id, Director director);
}
