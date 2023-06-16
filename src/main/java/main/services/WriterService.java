package main.services;

import main.entites.Writer;
import main.repositories.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriterService implements IWriterService {

    @Autowired
    private WriterRepository writerRepository;

    @Override
    public Writer updateWriter(int id, Writer writer) {
        writer.setId(id);
        return writerRepository.save(writer);
    }

}
