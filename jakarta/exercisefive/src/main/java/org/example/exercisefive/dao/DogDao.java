package org.example.exercisefive.dao;

import org.example.exercisefive.models.Dog;

public class DogDao extends BaseDao<Dog> {
    public DogDao() {
        super(Dog.class);
    }
}
