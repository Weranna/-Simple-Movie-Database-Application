package main.services;

import main.entites.Writer;
import org.springframework.stereotype.Service;

@Service
public interface IWriterService {

    Writer updateWriter(int id, Writer writer);
}
