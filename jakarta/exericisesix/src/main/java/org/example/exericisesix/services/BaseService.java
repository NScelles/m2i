package org.example.exericisesix.services;

import org.example.exericisesix.dao.BaseDao;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseService<T> {

    protected Map<Integer,T> list = new HashMap<>();
    protected static int idCounter = 0;
    protected BaseDao<T> dao;

    public BaseService(BaseDao<T> dao) {
        this.dao = dao;
    }

    public T save(int id, T entity) {
        //list.put(id,entity);
        dao.save(entity);
        return entity;
    }

    public boolean delete(int id) {
//        list.remove(id);
        dao.delete(dao.get(id));
        return true;
    }

    public List<T> get() {

        //return new ArrayList<>(list.values());
        return dao.get();
    }

    public T get(int id) {
        return dao.get(id); //list.get(id);
    }

    public T update(int id,T entity) {
        //list.replace(id,entity);
        dao.update(entity);
        return entity;
    }

    public int setId(){
        idCounter++;
        return idCounter;
    }
}
