package main.services;

import main.entites.Cinema;
import org.springframework.stereotype.Service;

@Service
public interface ICinemaService {

    Cinema updateCinema(int id, Cinema cinema);
}
