package main.services;

import main.entites.Premiere;
import main.repositories.PremiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PremiereService implements IPremiereService {

    @Autowired
    private PremiereRepository premiereRepository;

    @Override
    public Premiere updatePremiere(int id, Premiere premiere) {
        premiere.setId(id);
        return premiereRepository.save(premiere);
    }

}
