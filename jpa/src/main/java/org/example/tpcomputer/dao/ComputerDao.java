package org.example.tpcomputer.dao;

import org.example.exercice1.entity.animal.Animal;
import org.example.tpcomputer.models.Computer;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ComputerDao extends BaseDao<Computer> {

    @Override
    public List<Computer> get() {
        return em.createQuery("Select a from Computer a", Computer.class).getResultList();
    }
}
