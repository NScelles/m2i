package org.example.environmenttp.repositories;

import org.example.environmenttp.models.TravelLog;
import org.example.environmenttp.models.TravelMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface TravelLogRepository extends JpaRepository<TravelLog, UUID> {
    @Query("SELECT t FROM TravelLog t INNER JOIN Observation o ON t.observation.id = o.id WHERE o.id = ?1")
    public List<TravelLog> findTravelLogsByObservation(UUID observationId);
}
