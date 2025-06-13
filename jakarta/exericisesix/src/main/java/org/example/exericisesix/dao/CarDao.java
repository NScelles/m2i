package org.example.exericisesix.dao;

import org.example.exericisesix.models.Car;
import org.hibernate.Session;

public class CarDao extends BaseDao<Car> {
    public CarDao(Session session) {
        super(Car.class, session);
    }
}
