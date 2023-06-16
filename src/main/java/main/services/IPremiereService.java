package main.services;

import main.entites.Premiere;
import org.springframework.stereotype.Service;

@Service
public interface IPremiereService {

    Premiere updatePremiere(int id, Premiere premiere);
}
