package org.example.tpcomputer.dao;

import org.example.exercice1.entity.animal.Animal;
import org.example.tpcomputer.models.Computer;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ComputerDao extends BaseDao<Computer> {



    @Override
    public boolean save(Computer element) {
        try {
            em.getTransaction().begin();
            em.persist(element);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Computer element) {
        try {
            Computer computer = em.getReference(Computer.class,element.getId());
            em.getTransaction().begin();
            computer.setModel(element.getModel());
            computer.setIdentification(element.getIdentification());
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Computer element) {
        if(element!=null){
            em.getTransaction().begin();
            em.remove(element);
            em.getTransaction().commit();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Computer get(int id) {
        return em.find(Computer.class,id);
    }

    @Override
    public List<Computer> get() {
        List<Computer> computers = new ArrayList<Computer>();
        try {
            TypedQuery<Computer> query = em.createQuery("Select a from Computer a", Computer.class);
            computers = query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return em.createQuery("from Computer", Computer.class).getResultList();
    }
}
