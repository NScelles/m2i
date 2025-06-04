package org.example;

import org.example.productexercise.Ihm.GlobalIhm;
import org.example.productexercise.Ihm.ProductIhm;
import org.example.productexercise.dao.BaseDao;
import org.example.productexercise.models.Product;
import org.example.utils.SessionFactorySingleton;

public class Main {
    public static void main(String[] args) {
       GlobalIhm.start();
    }
}