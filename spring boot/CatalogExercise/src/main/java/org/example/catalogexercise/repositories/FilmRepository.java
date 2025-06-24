package org.example.catalogexercise.repositories;

import org.example.catalogexercise.models.Film;
import org.example.catalogexercise.models.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FilmRepository extends JpaRepository<Film, UUID> {
    @Query("SELECT p FROM  Producer p WHERE p.id = ?1")
    Producer findProducerById(UUID idProducer);

    @Query("SELECT f FROM Film f WHERE f.producer.id = ?1")
    List<Film> findFilmByProducer(UUID idProducer);
}
