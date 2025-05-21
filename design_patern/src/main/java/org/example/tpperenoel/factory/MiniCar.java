package org.example.tpperenoel.factory;


import org.example.tpperenoel.notification.Observer;

import java.util.List;

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
