package org.example.tpperenoel.decorator;

import org.example.tpperenoel.factory.Toy;

public abstract class ToyDecorator implements Toy {

    protected Toy toy;

    public ToyDecorator(Toy toy) {
        this.toy = toy;
    }

    @Override
    public void use() {

    }

    @Override
    public String getDescription() {
        return toy.getDescription();
    }
}
