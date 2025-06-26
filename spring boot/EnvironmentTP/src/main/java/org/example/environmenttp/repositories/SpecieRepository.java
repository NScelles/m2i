package org.example.environmenttp.repositories;

import org.example.environmenttp.models.Specie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface SpecieRepository extends JpaRepository<Specie, UUID> {

}
