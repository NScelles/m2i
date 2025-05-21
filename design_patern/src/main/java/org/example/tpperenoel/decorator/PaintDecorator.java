package org.example.tpperenoel.decorator;

import org.example.tpperenoel.factory.Toy;

public class PaintDecorator extends ToyDecorator {

    private String color;

    public PaintDecorator(Toy toy) {
        super(toy);
    }

    @Override
    public void use() {
        super.use();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " " +color;
    }
}
