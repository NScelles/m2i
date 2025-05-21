package org.example.behavioral;

import org.example.behavioral.observer.event.Event;
import org.example.behavioral.observer.event.EventManager;
import org.example.behavioral.observer.event.EventObserver;
import org.example.behavioral.observer.event.MyEventObserver;
import org.example.behavioral.observer.subject.MyObserver;
import org.example.behavioral.observer.subject.Observer;
import org.example.behavioral.observer.subject.Subject;

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        /// Observers
        Observer observerOne = new MyObserver("Nelson");
        Observer observerTwo = new MyObserver("Salim");



        subject.addObserver(observerOne);
        subject.addObserver(observerTwo);

        subject.notifyObserver("Un nouvelle article est arrivé");


        System.out.println("-----------------------------------------------");

        Event event = new Event("Avant première de The Chosen");
        EventManager eventManager = new EventManager(event);

        EventObserver eventObserverOne = new MyEventObserver("Nelson","Super");
        EventObserver eventObserverTwo = new MyEventObserver("Salim","ZZzzzzZ");

        eventManager.addObserver(eventObserverOne);
        eventManager.addObserver(eventObserverTwo);

        eventManager.notifyObserver("Début du film à 20h");
        eventManager.showOberserversReaction();

    }



}
