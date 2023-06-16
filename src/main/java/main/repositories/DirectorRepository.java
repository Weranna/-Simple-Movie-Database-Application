package main.repositories;

import main.entites.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DirectorRepository extends JpaRepository<Director, Integer> {

   @Query("SELECT d FROM Director d WHERE d.id = ?1")
   Optional<Director> findById(Integer id);

   List<Director> findByLastName(String lastName);
}
