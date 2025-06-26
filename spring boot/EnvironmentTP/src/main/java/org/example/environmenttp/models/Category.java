package org.example.environmenttp.models;

public enum Category {
    BIRD, MAMMAL, INSECT, PLANT, OTHER;

    public static Category getCategory(String category) {
        Category response;
        switch (category.toUpperCase()) {
            case "BIRD"-> response = Category.BIRD;
            case "MAMMAL"-> response = Category.MAMMAL;
            case "INSECT"-> response = Category.INSECT;
            case "PLANT"-> response = Category.PLANT;
            default -> response = Category.OTHER;
        }
        return response;
    }
}