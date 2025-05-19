package org.example.javapoo.exercicechaise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(List.of(new Chaise(),new Chaise(),new Chaise()));
        Map<String,String> test = new HashMap<>();

        test.put("1","zertrg");

        for (String key:test.keySet()){
            System.out.println(key);
        }

        for (String val:test.values()){
            System.out.println(val);
        }

        for (var entree:test.entrySet()){
            System.out.println(entree.getKey() + " " + entree.getValue());
        }

    }
}
