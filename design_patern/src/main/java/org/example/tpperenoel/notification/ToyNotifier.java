package org.example.tpperenoel.notification;

import org.example.tpperenoel.factory.Toy;

import java.util.ArrayList;
import java.util.List;

public abstract class ToyNotifier {

    protected List<Observer> toyManufacturer = new ArrayList<>();

    public void addObserver(Observer observer) {
        this.toyManufacturer.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.toyManufacturer.remove(observer);
    }

    public void isMadeNotifyObserver(Toy toy) {
        for (Observer observer:toyManufacturer)
            observer.onCreate(toy);
    }

}
