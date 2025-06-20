package org.example.furnitureexercise.services.furniture;

import org.example.furnitureexercise.models.CardItem;
import org.example.furnitureexercise.models.Furniture;
import org.example.furnitureexercise.repositories.furniture.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Primary
public class MySqlFurnitureService extends BaseFurnitureService {

    JpaRepository<Furniture, UUID> recipeRepository;

    @Autowired
    public MySqlFurnitureService(FurnitureRepository repository, JpaRepository<CardItem, UUID> cardItemRepository ) {
        super(repository);
        this.recipeRepository = recipeRepository;
    }


    @Override
    public List<Furniture> findByName(String name) {
        return repository.findAll().stream().filter(recipe -> recipe.getName().startsWith(name)).toList();
    }
}
