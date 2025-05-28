package org.example.tpcomputer.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public abstract class BaseDao<T> {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
    protected EntityManager em = emf.createEntityManager();

    public abstract boolean save(T element);
    public abstract boolean update(T element);
    public abstract boolean delete(T element);
    public abstract T get(int id);
    public abstract List<T> get();
}
