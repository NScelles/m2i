package org.example.tpperenoel.factory;

public class MiniCar implements Toy{

    @Override
    public void use() {
        System.out.println("Vroum Vroum");
    }

    @Override
    public String getDescription() {
        return "Une petite voiture";
    }
}
