package org.example.behavioral.observer.event;

import org.example.behavioral.observer.subject.Observer;

import java.util.ArrayList;
import java.util.List;

public class EventManager {

    private Event event;
    private List<EventObserver> eventObservers = new ArrayList<>();

    public EventManager(Event event) {
        this.event = event;
    }

    public void addObserver(EventObserver observer){
        eventObservers.add(observer);
    }

    public void removeObserver(EventObserver observer){
        eventObservers.remove(observer);
    }

    public void notifyObserver(String message){
        for (EventObserver observer:eventObservers)
            observer.sendMessage(message);
    }

    public void showOberserversReaction(){
        for (EventObserver observer:eventObservers)
            observer.react();
    }
}
