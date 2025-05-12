package org.example.algo.exemple;

import java.util.Scanner;

public class Exemple1 {
    public static void main(String[] args) {
        int a,b;
        Scanner scanner = new Scanner(System.in);

        System.out.println("entrer le nombre");
        a = scanner.nextInt();
        b = 2 * a;
        System.out.println("le double de " + a + " est " + b);
    }
}
