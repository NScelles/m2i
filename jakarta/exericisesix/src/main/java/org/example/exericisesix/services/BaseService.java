package org.example.exericisesix.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseService<T> {

    protected Map<Integer,T> list = new HashMap<>();
    protected static int idCounter = 0;

    public T save(int id,T entity) {
        list.put(id,entity);
        return entity;
    }

    public boolean delete(int id) {
        list.remove(id);
        return true;
    }

    public List<T> get() {
        return new ArrayList<>(list.values());
    }

    public T get(int id) {
        return list.get(id);
    }

    public T update(int id,T entity) {
        list.replace(id,entity);
        return entity;
    }

    public int setId(){
        idCounter++;
        return idCounter;
    }



}
