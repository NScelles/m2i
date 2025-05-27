package org.example.exercice1.entity.animal;

public enum AnimalDiet {
    CARNIVORE,
    HERBIVORE,
    OMNIVORE;

    public static AnimalDiet getAnimalDiet(String diet) {
        switch (diet) {
            case "carnivore": return AnimalDiet.CARNIVORE;
            case "herbivore": return AnimalDiet.HERBIVORE;
            case "omnivore": return AnimalDiet.OMNIVORE;
            default: return AnimalDiet.OMNIVORE;
        }
    }
}
