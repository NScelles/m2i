package org.example.algo.exercice;

import java.util.Scanner;

public class Noa {
    public static void main(String[] args) {
        int n=7;
        //for (int i = 1;i<=n;i++ System.out.println("@");
        lettreN(n);
        espace(n);
        lettreO(n);
        espace(n);
        lettreA(n);
        espace(n);
    }

    private static void lettreA(int n) {
        for (int i = 1; i<= n; i++)
            System.out.print("@");
        System.out.println();
        for(int i = 1; i<= n; i++) {
            for (int j = 0; j < n; j++)
                if (j == 0 || j == n -1 || i==(int)(n /2)+1)
                    System.out.print("@");
                else
                    System.out.print(" ");

            System.out.println();
        }
    }

    private static void lettreO(int n) {
        for (int i = 1; i<= n; i++)
            System.out.print("@");
        System.out.println();
        for(int i = 1; i<= n; i++) {
            for (int j = 0; j < n; j++)
                if (j == 0 || j == n -1)
                    System.out.print("@");
                else
                    System.out.print(" ");
            System.out.println();
        }
        for (int i = 1; i<= n; i++)
            System.out.print("@");
    }

    private static void espace(int n) {
        for(int i = 1; i<= n; i++)
            System.out.print(" ");
        System.out.println("\n");
    }

    private static void lettreN(int n) {
        for (int i = 1; i<= n; i++) {
            System.out.println();
                for (int j = 0; j < n; j++)
                    if(j==0||j==i-1||j==n-1)
                        System.out.print("@");
                    else
                        System.out.print(" ");

        }
    }
}
