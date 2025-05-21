package org.example.tpperenoel.factory;

public class MiniCarFactory extends ToyFactory {
    @Override
    public Toy createToy() {
        return new MiniCar();
    }
}
