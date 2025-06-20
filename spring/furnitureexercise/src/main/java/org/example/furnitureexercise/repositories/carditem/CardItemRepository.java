package org.example.furnitureexercise.repositories.carditem;

import org.example.furnitureexercise.models.CardItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CardItemRepository extends JpaRepository<CardItem, UUID> {

}
