package org.example.behavioral.observer.subject;

public class MyObserver implements Observer{

    private String name;

    public MyObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(this.name + " a reçu un message :" + message);
    }
}
