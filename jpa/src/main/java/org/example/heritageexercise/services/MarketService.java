package org.example.heritageexercise.services;

import org.example.heritageexercise.dao.ElectronicDao;
import org.example.heritageexercise.dao.FoodDao;
import org.example.heritageexercise.dao.HousingDao;
import org.example.heritageexercise.models.Electronic;
import org.example.heritageexercise.models.Food;
import org.example.heritageexercise.models.Housing;
import org.example.tpcomputer.models.Computer;
import org.example.tpcomputer.models.Identification;
import org.example.tpcomputer.models.OperatingSystem;
import org.example.tpcomputer.models.Processor;

import java.sql.Date;
import java.util.List;

public class MarketService {
    ElectronicDao electronicDao = new ElectronicDao();
    FoodDao foodDao = new FoodDao();
    HousingDao housingDao = new HousingDao();

    /// CRUD Electronic
    public void createElectronic(String name, double price, double batteryDuration) {
        Electronic electronic = Electronic.builder().name(name).price(price).batteryDuration(batteryDuration).build();
        electronicDao.save(electronic);
    }

    public Electronic getElectronic(int id){
        return electronicDao.get(id,Electronic.class);
    }

    public List<Electronic> getElectronics(){
        return electronicDao.get();
    }

    public void updateElectronic(Electronic electronic) {
        electronicDao.update(electronic);
    }

    public void deleteElectronic(int id) {
        electronicDao.delete(id,Electronic.class);
    }

    /// CRUD Food
    public void createFood(String name, double price, String experyDate) {
        Food food = Food.builder().name(name).price(price).expiryDate(experyDate).build();
        foodDao.save(food);
    }

    public Food getFood(int id){
        return foodDao.get(id,Food.class);
    }

    public List<Food> getFoods(){
        return foodDao.get();
    }

    public void updateFood(Food food) {
        foodDao.update(food);
    }

    public void deleteFood(int id) {
        foodDao.delete(id,Food.class);
    }

    /// CRUD Housing
    public void createHousing(String name, double price, double height, double width) {
        Housing housing = Housing.builder().name(name).price(price).height(height).width(width).build();
        housingDao.save(housing);
    }

    public Housing getHousing(int id){
        return housingDao.get(id,Housing.class);
    }

    public List<Housing> getHousings(){
        return housingDao.get();
    }

    public void updateHousing(Housing housing) {
        housingDao.update(housing);
    }

    public void deleteHousing(int id) {
        housingDao.delete(id, Housing.class);
    }

}
