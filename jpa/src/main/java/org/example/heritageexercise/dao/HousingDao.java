package org.example.heritageexercise.dao;

import org.example.heritageexercise.models.Housing;

import java.util.List;

public class HousingDao extends BaseDao<Housing> {

    @Override
    public List<Housing> get() {
        return em.createQuery("Select h from Housing h", Housing.class).getResultList();
    }
}
