package org.example.exericisesix.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactorySingleton {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    private SessionFactorySingleton() {
        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static void initSessionFactory() {
        // Force Hibernate à créer les tables au démarrage
        try (Session session = getSession()){
            session.beginTransaction();
            session.getTransaction().commit();
        }
    }

    public static Session getSession (){
        if(sessionFactory == null){
            new SessionFactorySingleton();
        }
        return sessionFactory.openSession();
    }

    public static void close(){
        sessionFactory.close();
        registry.close();
    }
}
