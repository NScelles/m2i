package org.example.tpcomputer;

import org.example.tpcomputer.models.Identification;
import org.example.tpcomputer.services.EquipementService;

public class Main {
    public static void main(String[] args) {
        EquipementService equipementService = new EquipementService();

        equipementService.createComputer("DELL", Identification.builder().ipAddress("08185941594").macAddress("417189 8948 17894191 89").build());
        equipementService.createComputer("HP", Identification.builder().ipAddress("714844889").macAddress("243978 28752 32786 689732").build());

        System.out.println(equipementService.get());
    }
}
