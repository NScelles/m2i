package org.example.creational.factory_method.vehicle;

public class TruckFactory extends VehicleFactory {



    @Override
    public Vehicle createVehicle() {
        return new Truck();
    }
}
