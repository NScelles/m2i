package org.example.exercisefive.services;

import org.example.exercisefive.dao.DogDao;
import org.example.exercisefive.models.Dog;

import java.time.LocalDate;
import java.util.List;

public class PetService {
    DogDao dogDao = new DogDao();

    public void createDog(String name,String breed, LocalDate birthday) {
        Dog dog = Dog.builder().name(name).breed(breed).birthDate(birthday).build();
        dogDao.save(dog);
    }

    public Dog getDog(int id){
        return dogDao.get(id);
    }

    public List<Dog> getDogs(){
        return dogDao.get();
    }

    public void updateDog(Dog dog) {
        dogDao.save(dog);
    }

    public void deleteDog(Dog dog) {
        dogDao.delete(dog);
    }

}
