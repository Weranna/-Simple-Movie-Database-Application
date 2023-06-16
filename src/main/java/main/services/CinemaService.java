package main.services;

import main.entites.Cinema;
import main.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService implements ICinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public Cinema updateCinema(int id, Cinema cinema) {
        cinema.setId(id);
        return cinemaRepository.save(cinema);
    }

}
