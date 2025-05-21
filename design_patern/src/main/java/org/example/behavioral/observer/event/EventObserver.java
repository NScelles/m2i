package org.example.behavioral.observer.event;

public class EventObserver implements Observer {

    private String name;
    private String reaction;

    public EventObserver(String name, String reaction) {
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
