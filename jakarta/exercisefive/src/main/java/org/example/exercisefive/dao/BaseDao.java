package org.example.exercisefive.dao;


import org.example.exercisefive.utils.SessionFactorySingleton;
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
        session.persist(element);
        session.getTransaction().commit();
        return element;
    }

    public T update (T element){
        session.beginTransaction();
        session.merge(element);
        session.getTransaction().commit();
        return element;
    }

    public boolean delete (T element){
        session.beginTransaction();
        session.remove(element);
        session.getTransaction().commit();
        return true;
    }

    public T get (int id){
        return session.get(tClass,id);
    }

    public  List<T> get () {
        List<T> elements = session.createQuery("select c from "+tClass.getSimpleName()+" c", tClass).getResultList();
        for (T element:elements)
            session.refresh(element);
        return elements;
    }
}
