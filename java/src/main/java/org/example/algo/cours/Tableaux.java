package org.example.algo.cours;

import java.util.Arrays;

import static org.example.outils.Outils.getReel;

public class Tableaux {
    public static void main(String[] args) {
        /// Constante
        final int N = 30;

        /// Déclaration de tableaux
        //int[] ages;
        /// Allocation de l mémoire pour 30
        int[] ages = new int[N];
        for(int i=0;i<ages.length;i++)
            ages[i]= (int) Math.floor(Math.random()*100);
        System.out.println(Arrays.toString(ages));

        /// Connaître la taille du tableau
        System.out.println("La taille du tableau est : " + ages.length);

        for (int age : ages) System.out.println("éléments à l'index " + age);

        /// Syntaxe pour déclarer et allouer diretement un tableau
        String[] prenoms = {"Noa","Nelson","Salim"};
        for (String prenom : prenoms) System.out.println("éléments à l'index " + prenom);

        /// Tableau multi dimensional
        final int M=15,O=3;
        double[][] tab=new double[M][O];
        for (int i = 0;i<M;i++)
            for(int j=0;j<O;j++)
                tab[i][j]=getReel("Donnez la note de l'étudiant numéro "+ (i+1) + " pour la matière numéro " + j );

    }
}
