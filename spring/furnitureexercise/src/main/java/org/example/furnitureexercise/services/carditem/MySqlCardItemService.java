package org.example.furnitureexercise.services.carditem;

import org.example.furnitureexercise.models.CardItem;
import org.example.furnitureexercise.models.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Primary
public class MySqlCardItemService extends BaseCardItemService {

    protected JpaRepository<Furniture,UUID> furnitureRepository;

    @Autowired
    public MySqlCardItemService(JpaRepository<CardItem,UUID> repository, JpaRepository<Furniture,UUID> furnitureRepository) {
        super(repository);
        this.furnitureRepository = furnitureRepository;
    }


    @Override
    public Furniture updateFurniture(Furniture furniture) {
        return furnitureRepository.save(furniture);
    }

    @Override
    public Furniture findFurnitureById(UUID id) {
        return furnitureRepository.findById(id).orElse(null);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

}
