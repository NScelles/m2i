package org.example.exercicejavabase;
import static org.example.outils.Outils.getString;

public class exercice1 {
    public static void main(String[] args) {
        String prenom = getString("Saisir un prenom : "),
                nom = getString("Saisir un nom : ");
        System.out.print("Bnojour" + prenom + " " + nom);
    }
}
