package org.example.algo.cours;

public class fonctionProcedure {
    public static void main(String[] args) {
        System.out.println(perimetreRectangle(10,15));
    }

    /// Syntaxe
    // Visibilité autre-caractérisque type-de-retour nom-de-la-fonction(paramètre)
    public static double perimetreRectangle(int largeur,int longueur) {
        return 2*(largeur+longueur);
    }
}
