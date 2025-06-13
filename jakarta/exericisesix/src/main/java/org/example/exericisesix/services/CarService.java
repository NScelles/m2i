package org.example.exericisesix.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.exericisesix.dao.BaseDao;
import org.example.exericisesix.dao.CarDao;
import org.example.exericisesix.models.Car;
import org.example.exericisesix.utils.SessionFactorySingleton;
import org.hibernate.Session;

@ApplicationScoped
public class CarService extends BaseService<Car>{

    public CarService() {
        super(new CarDao());
    }
}
