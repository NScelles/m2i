package org.example.environmenttp.models;

public enum TravelMode {
    WALKING, BIKE, CAR, BUS, TRAIN, PLANE;


    public static Double getEmission(TravelMode travelMode) {
        Double response;
        switch (travelMode) {
            case WALKING-> response = 0.0;
            case BIKE-> response = 0.0;
            case CAR-> response = 0.22;
            case BUS-> response = 0.11;
            case TRAIN-> response = 0.03;
            case PLANE-> response = 0.259;
            default -> response = null;
        }
        return response;
    }
}
