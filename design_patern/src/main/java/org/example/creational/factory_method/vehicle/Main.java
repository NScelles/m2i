package org.example.creational.factory_method.vehicle;

public class Main {
    public static void main(String[] args) {
        //VehicleFactory carFactory = ;
        VehicleFactory truckFactory = new TruckFactory();
        new CarFactory().createVehicle().drive();
        truckFactory.createVehicle().drive();
    }
}
