package org.example.algo.cours;

public class Operateurs {
    public static void main(String[] args) {

        /// Concatenation
        String string1 = "Hello";
        String string2 = "World";
        String message = string1 + " " + string2;



        /// Region Operateurs Arithmétiques

        int result = 1 + 2;
        System.out.println("1 + 2 = " + result);
        int originalResult = result;

        result--;
        System.out.println(originalResult + " - 1 = " + result);
        originalResult = result;

        result *= 2;
        System.out.println(originalResult + " * 2 = " + result);
        originalResult = result;

        result /= 2;
        System.out.println(originalResult + " / 2 = " + result);

        result += 8;
        originalResult = result;
        result %= 7;

        System.out.println(originalResult + " modulo 7 = " + result);

        // Operateur d'incrementation et de décrémentation

        int nombre = +1; // nombre = 1
        nombre--;        // nombre = 0
        nombre++;        // nombre = 1

        // Écriture raccourci

        nombre = nombre + 10;
        nombre += 10;

        // Opérateur Not

        boolean estBoolean = true;
        estBoolean = !estBoolean;

        //Opérateur d'égalité relationnels
        int value1 = 1;
        int value2 = 2;
        boolean resultatBool;

        resultatBool = value1 == value2; // false
        System.out.println(value1 + " == " + value2 + " : " + resultatBool);

        resultatBool = value1 != value2; // true
        System.out.println(value1 + " != " + value2 + " : " + resultatBool);

        resultatBool = value1 > value2; // false
        System.out.println(value1 + " > " + value2 + " : " + resultatBool);

        resultatBool = value1 < value2; // true
        System.out.println(value1 + " < " + value2 + " : " + resultatBool);

        // Opérateur OU et ET
        resultatBool =  value1 == 1 && value2 == 2;
        System.out.println(value1 + " == 1  && " + value2 + " == 2 : " + resultatBool);

            resultatBool =  value1 == 1 || value2 == 1;
        System.out.println(value1 + " == 1  || " + value2 + " == 1 : " + resultatBool);

    }
}
