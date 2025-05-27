package org.example.demos;

import org.example.demos.entity.Account;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
        EntityManager em = emf.createEntityManager();


        /// CREATE
        Account account = new Account(777,"Noa","7777777");
        Account account2 = new Account(500,"Nelou","123456789");

        Account account3 = new Account(777,"Noa","7777777");
        Account account4 = new Account(500,"Nelou","123456789");

        em.getTransaction().begin();
        em.persist(account);
        em.persist(account2);
        em.persist(account3);
        em.persist(account4);
        em.getTransaction().commit();
        /// READ
        //find
        Account accountfind = em.find(Account.class,2);
        if(accountfind != null){
            System.out.println(accountfind);
        }else{
            System.out.println("No Account found");
        }


        //getReference
        try{
            Account accountfindByReference = em.getReference(Account.class,4);
            System.out.println(accountfindByReference);
        }catch (EntityNotFoundException ex){
            System.out.println(ex.getMessage());
        }


        TypedQuery<Account> query = em.createQuery("Select a from Account a where a.amount > 500", Account.class);
        List<Account> accounts = query.getResultList();

        accounts.forEach(System.out::println);

        /// UPDATE
        try {
            Account accountToUpdate = em.getReference(Account.class,2);
            em.getTransaction().begin();
            accountToUpdate.setAmount(450);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(em.find(Account.class,2));

        /// DELETE

        Account accountToDelete = em.find(Account.class,1);
        if(accountToDelete!=null){
            em.getTransaction().begin();
            em.remove(accountToDelete);
            em.getTransaction().commit();
        }

        Account accountToDelete2 = em.find(Account.class,2);
        if(accountToDelete!=null){
            em.getTransaction().begin();
            em.remove(accountToDelete);
            em.getTransaction().commit();
      }
    }
}