package org.example.exericisesix.resources;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.exericisesix.models.Car;
import org.example.exericisesix.services.CarService;
import java.util.List;

@Path("/car")
public class CarResources {

    private CarService carService;

    @Inject
    public CarResources(CarService carService) {
        this.carService = carService;
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
        //.setId(carService.setId());
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
