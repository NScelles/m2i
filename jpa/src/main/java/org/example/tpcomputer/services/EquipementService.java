package org.example.tpcomputer.services;

import lombok.NoArgsConstructor;
import org.example.exercice1.entity.animal.Animal;
import org.example.exercice1.entity.animal.AnimalDiet;
import org.example.tpcomputer.dao.ComputerDao;
import org.example.tpcomputer.models.Computer;
import org.example.tpcomputer.models.Identification;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
public class EquipementService {

    private ComputerDao computerDao = new ComputerDao();

    public void createComputer(String model, Identification identification) {
        Computer computer = Computer.builder().model(model).identification(identification).build();
        computerDao.save(computer);
    }

    public Computer get (int id){
        return computerDao.get(id);
    }

    public List<Computer> get (){
        return computerDao.get();
    }

    public void update(Computer computer) {
        computerDao.update(computer);
    }

    public void delete (int id) {
        computerDao.delete(computerDao.get(id));
    }
}
