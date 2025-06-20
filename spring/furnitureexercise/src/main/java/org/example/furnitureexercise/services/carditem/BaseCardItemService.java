package org.example.furnitureexercise.services.carditem;

import org.example.furnitureexercise.models.CardItem;
import org.example.furnitureexercise.models.Furniture;
import org.example.furnitureexercise.services.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public abstract class BaseCardItemService extends BaseService<CardItem> {


    public BaseCardItemService(JpaRepository<CardItem,UUID> repository) {
        super(repository);
    }

    public abstract Furniture findFurnitureById(UUID id);

    public abstract void deleteAll();

}
