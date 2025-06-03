package org.example.productexercise.dao;

import org.example.utils.SessionFactorySingleton;
import org.hibernate.Session;

import java.util.List;

public abstract class BaseDao<T> {
    protected Session session = SessionFactorySingleton.getSession();

    public T save (T element){
        session.beginTransaction();
//        session.getTransaction().begin();
        session.saveOrUpdate(element);
        session.getTransaction().commit();
        return element;
    }

    public boolean delete (T element){
        session.beginTransaction();
        session.delete(element);
        session.getTransaction().commit();
        return true;
    }

    public T get (int id, Class<T> tClass ){
        return session.get(tClass,id);
    }


    public abstract List<T> get ();
        //return session.createQuery("select p from Personne p", Personne.class).getResultList();



}
