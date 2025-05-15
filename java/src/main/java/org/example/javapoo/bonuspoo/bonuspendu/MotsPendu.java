package org.example.javapoo.bonuspoo.bonuspendu;

import java.util.ArrayList;
import java.util.List;

public abstract class MotsPendu {
    private static List<String> mots = List.of("test","start","lebossdujava");

    public static String getMotAlea(){
        return mots.get((int) (Math.random() * mots.size()));
    }

    public static void addMots(String nouveauMots) {
        mots.add(nouveauMots);
    }

    public static List<String> getMots() {
        return mots;
    }

    public static void setMots(List<String> nouvelleListeMots) {
        mots = nouvelleListeMots;
    }
}


