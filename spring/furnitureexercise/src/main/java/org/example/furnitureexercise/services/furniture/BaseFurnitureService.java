package org.example.furnitureexercise.services.furniture;

import org.example.furnitureexercise.models.Furniture;

import org.example.furnitureexercise.services.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public abstract class BaseFurnitureService extends BaseService<Furniture> {

    public BaseFurnitureService(JpaRepository<Furniture,UUID> repository) {
        super(repository);
    }
    public abstract List<Furniture> findByName(String name);
}
