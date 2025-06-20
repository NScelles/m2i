package org.example.kitchenexercise.services.category;

import org.example.kitchenexercise.models.Category;
import org.example.kitchenexercise.models.Recipe;
import org.example.kitchenexercise.repositories.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MySqlCategoryService extends BaseCategoryService {

    JpaRepository<Recipe, UUID> recipeRepository;

    @Autowired
    public MySqlCategoryService(CategoryRepository repository,JpaRepository<Recipe, UUID> recipeRepository ) {
        super(repository);
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void delete(UUID id) {
        recipeRepository.deleteAll(recipeRepository.findAll().stream().filter(recipe -> recipe.getCategory().getId().equals(id)).collect(Collectors.toList()));
        super.delete(id);
    }

    @Override
    public List<Category> findByName(String name) {
        return repository.findAll().stream().filter(recipe -> recipe.getName().startsWith(name)).toList();
    }
}
