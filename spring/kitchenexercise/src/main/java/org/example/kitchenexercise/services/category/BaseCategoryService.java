package org.example.kitchenexercise.services.category;

import org.example.kitchenexercise.models.Category;
import org.example.kitchenexercise.services.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public abstract class BaseCategoryService extends BaseService<Category> {

    public BaseCategoryService(JpaRepository<Category,UUID> repository) {
        super(repository);
    }
    public abstract List<Category> findByName(String name);
}
