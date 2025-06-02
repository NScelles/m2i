package org.example.heritageexercise.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Electronic extends Product {
    private double batteryDuration;

    @Override
    public String toString() {
        return "Electronic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", batteryDuration=" + batteryDuration +
                '}';
    }
}
