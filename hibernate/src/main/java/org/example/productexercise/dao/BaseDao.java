package org.example.productexercise.dao;

import org.example.utils.SessionFactorySingleton;
import org.hibernate.Session;

import java.util.List;

public abstract class BaseDao<T> {
    protected Session session = SessionFactorySingleton.getSession();
    protected Class<T> tClass;

    public BaseDao(Class<T> tClass) {
        this.tClass = tClass;
    }

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

    public  List<T> get (Class<T> tClass) {
        //String[] className = ;
        return session.createQuery("select c from "+tClass.getSimpleName()+" c", tClass).getResultList();
    }
}
