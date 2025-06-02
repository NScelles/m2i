package org.example.heritageexercise.dao;

import org.example.heritageexercise.models.Electronic;
import org.example.tpcomputer.models.Computer;

import java.util.List;

public class ElectronicDao extends BaseDao<Electronic> {
    @Override
    public List<Electronic> get() {
        return em.createQuery("Select e from Electronic e", Electronic.class).getResultList();
    }
}
