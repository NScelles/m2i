package org.example.tpperenoel.factory;

import org.example.tpperenoel.notification.Observer;

import java.util.List;

public abstract class ToyFactory {
    protected List<Observer> toyManufacturer;
    public abstract Toy createToy();
}
