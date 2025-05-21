package org.example.tpperenoel.decorator;

import org.example.tpperenoel.factory.Toy;
import org.example.tpperenoel.factory.ToyFactory;
import org.example.tpperenoel.notification.Observer;

public class PaintDecorator extends ToyDecorator {

    private String color;

    public PaintDecorator(Toy toy,String color) {
        super(toy);
        this.color = color;
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
