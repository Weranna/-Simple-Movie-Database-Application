package main.repositories;

import main.entites.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WriterRepository extends JpaRepository<Writer, Integer> {

    List<Writer> findByLastName(String lastName);
}
