package org.example.sessionexercise.repositories;

import org.example.sessionexercise.models.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query("SELECT p FROM Product p WHERE p.id in ?1")
    List<Product> findProductsByIds(List<UUID> uuids);

    @Query("SELECT sum(p.price) FROM Product p WHERE p.id in ?1")
    Double findSumPriceByIds(List<UUID> uuids);
}
