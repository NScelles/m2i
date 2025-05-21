package org.example.tpperenoel.factory;

import org.example.behavioral.observer.event.Observer;
import org.example.tpperenoel.notification.ToyNotifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SantaClausFactory extends ToyNotifier {
    private Map<String,ToyFactory> factories = new HashMap<>();

    public void registerFactory(String typeFactory,ToyFactory factory){
        factories.put(typeFactory,factory);
    }

    public Toy makeToy(String typeToy){
        ToyFactory factory = factories.get(typeToy);
        Toy toy = factory.createToy();
        this.isMadeNotifyObserver(toy);
        return toy;
    }



}
