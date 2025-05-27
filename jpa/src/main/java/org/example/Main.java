package org.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory ref = Persistence.createEntityManagerFactory("demo_jpa");
        
    }
}