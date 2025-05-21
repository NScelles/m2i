package org.example.behavioral.observer.event;

public class MyEventObserver implements EventObserver{

    private String name;
    private String reaction;

    public MyEventObserver(String name,String reaction) {
        this.name = name;
        this.reaction = reaction;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(this.name + " a reçu un message :" + message);
    }

    @Override
    public void react() {
        System.out.println(name + ":" + reaction);
    }
}
