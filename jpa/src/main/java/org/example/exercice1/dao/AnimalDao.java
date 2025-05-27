package org.example.exercice1.dao;

import org.example.demos.entity.Account;
import org.example.exercice1.entity.animal.Animal;
import org.example.exercice1.entity.animal.AnimalDiet;

import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AnimalDao extends BaseDao<Animal> {

    @Override
    public boolean save(Animal element) {
        try {
            em.getTransaction().begin();
            em.persist(element);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Animal element) {
        try {
            Animal animal = em.getReference(Animal.class,element.getId());
            em.getTransaction().begin();
            animal.setName(element.getName());
            animal.setAge(element.getAge());
            animal.setDiet(element.getDiet());
            animal.setArrivalDate(element.getArrivalDate());
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Animal element) {

        if(element!=null){
            em.getTransaction().begin();
            em.remove(element);
            em.getTransaction().commit();
            return true;
        } else {
            return false;
        }
    }

    public Animal get(int id) {
        Animal animal = em.find(Animal.class,id);
        if(animal != null){
            return animal;
        }else{
            return null;
        }
    }

    public List<Animal> getByName(String name) {
        TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a WHERE a.name = :name", Animal.class);
        query.setParameter("name", name);
        List<Animal> animals = query.getResultList();
        return animals;
    }

    public List<Animal> getByDiet(AnimalDiet animalDiet) {
        TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a WHERE a.diet = :diet", Animal.class);
        query.setParameter("diet", animalDiet);
        List<Animal> animals = query.getResultList();
        return animals;
    }


    @Override
    public List<Animal> get() {
        List<Animal> animals = new ArrayList<Animal>();
        try {
            TypedQuery<Animal> query = em.createQuery("Select a from Animal a", Animal.class);
            animals = query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return em.createQuery("from Animal", Animal.class).getResultList();
    }


}
