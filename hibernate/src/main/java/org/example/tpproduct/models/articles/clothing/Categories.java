package org.example.tpproduct.models.articles.clothing;

public enum Categories {
    HOMME,
    FEMME,
    ENFANT;

    public static Categories getCatergories(String s){
        Categories rslt = null;
        switch (s){
            case "HOMME" -> rslt = Categories.HOMME;
            case "FEMME" -> rslt = Categories.FEMME;
            case "ENFANT" -> rslt = Categories.ENFANT;
            default -> rslt = null;
        }
        return rslt;
    }
}
