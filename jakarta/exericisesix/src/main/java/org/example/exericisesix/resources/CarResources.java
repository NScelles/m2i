package org.example.exericisesix.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.exericisesix.models.Car;
import org.example.exericisesix.services.CarService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Path("/car")
public class CarResources {

    private CarService carService;

    @Inject
    public CarResources(CarService carService) {
        this.carService = carService;
    }

    @GET
    @Path("/setCars")
    @Produces(MediaType.APPLICATION_JSON)
    public String setCars() {
        Car car1 = new Car(1,"marque1",2020,"blue");
        Car car2 = new Car(2,"marque2", 8520,"red");
        Car car3 = new Car(3,"marque3", 128,"yellow");
        carService.save(1,car1);
        carService.save(2,car2);
        carService.save(3,car3);
        return "C'est bon";
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> get() {
        return carService.get();
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car get(@PathParam("id") int id) {
        return carService.get(id);
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Car add(Car car) {
        car.setId(carService.setId());
        carService.save(car.getId(),car);
        return carService.get(car.getId());
    }

    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Car update(Car car) {
        carService.update(car.getId(),car);
        return carService.get(car.getId());
    }

    @DELETE
    @Path("/delete/{id}")
    public int delete(@PathParam("id") int id){
        carService.delete(id);
        return id;
    }

}
