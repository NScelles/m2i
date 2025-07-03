package org.example.product.repositories;

import org.example.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProuctRepository extends JpaRepository<Product, UUID> {

}
