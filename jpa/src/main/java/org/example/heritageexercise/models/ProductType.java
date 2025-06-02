package org.example.heritageexercise.models;

public enum ProductType {
    ELECTRONIC,
    FOOD,
    HOUSING;

    public static ProductType getProductType(String productType) {
        ProductType result = null;
        switch (productType) {
            case "ELECTRONIC" -> result = ELECTRONIC;
            case "FOOD" -> result = FOOD;
            case "HOUSING" -> result = HOUSING;
            default -> result = null;
        }
        return result;
    }

}
