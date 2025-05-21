package org.example.tpperenoel.factory;

import org.example.tpperenoel.notification.Observer;

public class MiniCarFactory extends ToyFactory {

    @Override
    public Toy createToy() {
        MiniCar miniCar = new MiniCar();
        return miniCar;
    }
}
