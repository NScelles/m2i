package org.example.behavioral;

import org.example.behavioral.observer.event.Event;
import org.example.behavioral.observer.event.EventManager;
import org.example.behavioral.observer.event.Observer;
import org.example.behavioral.observer.event.EventObserver;
import org.example.behavioral.observer.subject.MyObserver;
import org.example.behavioral.observer.subject.Subject;

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        /// Observers
        org.example.behavioral.observer.subject.Observer observerOne = new MyObserver("Nelson");
        org.example.behavioral.observer.subject.Observer observerTwo = new MyObserver("Salim");



        subject.addObserver(observerOne);
        subject.addObserver(observerTwo);

        subject.notifyObserver("Un nouvelle article est arrivé");


        System.out.println("-----------------------------------------------");

        Event event = new Event("Avant première de The Chosen");
        EventManager eventManager = new EventManager(event);

        Observer eventObserverOne = new EventObserver("Nelson","Super");
        Observer eventObserverTwo = new EventObserver("Salim","ZZzzzzZ");

        eventManager.addObserver(eventObserverOne);
        eventManager.addObserver(eventObserverTwo);

        eventManager.notifyObserver("Début du film à 20h");
        eventManager.showOberserversReaction();

    }



}
