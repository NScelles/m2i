package org.example.exercice1.services;

import org.example.exercice1.dao.AnimalDao;
import org.example.exercice1.entity.animal.Animal;
import org.example.exercice1.entity.animal.AnimalDiet;

import java.sql.Date;
import java.util.List;

public class ZooService {

    private AnimalDao animalDao = new AnimalDao();

    public ZooService() {}

    public void createAnimal(String name, int age, AnimalDiet animalDiet, Date arrivalDate) {
        Animal animal = new Animal(name, age, animalDiet, arrivalDate);
        animalDao.save(animal);
    }

    public Animal getAnimalById (int id){
        return animalDao.get(id);
    }

    public List<Animal> getByName(String name) {
        return animalDao.getByName(name);
    }

    public List<Animal> getByDiet(AnimalDiet animalDiet) {
        return animalDao.getByDiet(animalDiet);
    }
}
