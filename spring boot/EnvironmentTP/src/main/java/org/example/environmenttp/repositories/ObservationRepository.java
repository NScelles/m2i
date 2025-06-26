package org.example.environmenttp.repositories;

import org.example.environmenttp.models.Observation;
import org.example.environmenttp.models.Specie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ObservationRepository extends JpaRepository<Observation, UUID> {
    @Query("SELECT o FROM Observation o WHERE o.location = ?1")
    public List<Observation> findObservationsByLocation(String location);

    @Query("SELECT o FROM Observation o WHERE o.specie.id = ?1")
    List<Observation> findObservationsBySpecie(UUID specie);
}
