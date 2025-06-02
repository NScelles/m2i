package org.example.tpcomputer;

import org.example.tpcomputer.Ihm.EquipementIhm;
import org.example.tpcomputer.Ihm.GlobalIhm;
import org.example.tpcomputer.models.Identification;
import org.example.tpcomputer.services.EquipementService;

public class Main {
    public static void main(String[] args) {
//        EquipementService marketService = new EquipementService();
//
//        marketService.createComputer("DELL", Identification.builder().ipAdress("08185941594").macAdress("417189 8948 17894191 89").build());
//        marketService.createComputer("HP", Identification.builder().ipAdress("714844889").macAdress("243978 28752 32786 689732").build());
//
//        System.out.println(marketService.get());
//
        EquipementService equipementService = new EquipementService();

        //marketService.createOperatingSystem("iOS","10");
        //marketService.createProcessor("AMD","Ryzen 7","580x");

        GlobalIhm.start();
    }
}
