package org.example.exericisesix.dao;


import org.example.exericisesix.utils.SessionFactorySingleton;
import org.hibernate.Session;

import java.util.List;

public abstract class BaseDao<T> {


    protected Session session;
    protected Class<T> tClass;

    public BaseDao(Class<T> tClass) {
        this.tClass = tClass;
    }

    public T save (T element){

        try {
            session= SessionFactorySingleton.getSession();
            session.beginTransaction();
//        session.getTransaction().begin();
            session.persist(element);
            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
            throw new RuntimeException(e);
        }finally {
            session.close();
        }
        return element;
    }

    public T update (T element){

        try {
            session = SessionFactorySingleton.getSession();
            session.beginTransaction();
            session.merge(element);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
        return element;
    }

    public boolean delete (T element){
        try {
            session = SessionFactorySingleton.getSession();
            session.beginTransaction();
            session.remove(element);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
        return true;
    }

    public T get (int id){
        T element = null;
        try {
            session = SessionFactorySingleton.getSession();
            element = session.get(tClass,id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
        return element;
    }

    public  List<T> get () {
        List<T> elements = null;

        try {
            session = SessionFactorySingleton.getSession();
            elements = session.createQuery("select c from "+tClass.getSimpleName()+" c", tClass).getResultList();
            for (T element:elements)
                session.refresh(element);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
        return elements;
    }
}

