package org.example.utils;

import java.sql.Connection;
import java.util.List;

public abstract class Service<T> {
    protected Connection connection;

    public abstract boolean create(String[] args);
    public abstract boolean update(T element);
    public abstract T get(int id);
    public abstract boolean delete(int id);
    public abstract List<T> getAll();
}
