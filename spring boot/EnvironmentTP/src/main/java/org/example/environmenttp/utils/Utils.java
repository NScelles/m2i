package org.example.environmenttp.utils;

import org.example.environmenttp.models.TravelMode;

public abstract class Utils {
    public static Double getEstimatedCo2Kg(double distanceKm, TravelMode mode) {
        return distanceKm * TravelMode.getEmission(mode);
    }
}
