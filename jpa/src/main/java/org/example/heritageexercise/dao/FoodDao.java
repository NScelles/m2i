package org.example.heritageexercise.dao;

import org.example.heritageexercise.models.Food;
import org.example.tpcomputer.models.Computer;

import java.util.List;

public class FoodDao extends BaseDao<Food> {

    @Override
    public List<Food> get() {
        return em.createQuery("Select f from Food f", Food.class).getResultList();
    }
}
