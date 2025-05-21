package org.example.behavioral.observer.event;

import java.util.ArrayList;
import java.util.List;

public class EventManager {

    private Event event;
    private List<Observer> eventObservers = new ArrayList<>();

    public EventManager(Event event) {
        this.event = event;
    }

    public void addObserver(Observer observer){
        eventObservers.add(observer);
    }

    public void removeObserver(Observer observer){
        eventObservers.remove(observer);
    }

    public void notifyObserver(String message){
        for (Observer observer:eventObservers)
            observer.sendMessage(message);
    }

    public void showOberserversReaction(){
        for (Observer observer:eventObservers)
            observer.react();
    }
}
