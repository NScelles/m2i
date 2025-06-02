package org.example.heritageexercise.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public abstract class BaseDao<T> {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
    protected EntityManager em = emf.createEntityManager();

    public T save (T element){
        em.getTransaction().begin();
        em.persist(element);
        em.getTransaction().commit();
        return element;
    }

    public T update (T element){
        try{
            em.getTransaction().begin();
            em.merge(element);
            em.getTransaction().commit();
            return element;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean delete (int id,Class<T> tClass){
        T elementFound = get(id,tClass);
        if(elementFound != null){
            em.getTransaction().begin();
            em.remove(elementFound);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }

    public T get(int id,Class<T> tClass){
        return em.find(tClass,id);
    }

    public abstract List<T> get();
}
