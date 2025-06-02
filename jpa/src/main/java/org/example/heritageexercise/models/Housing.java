package org.example.heritageexercise.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Housing extends Product{
    private double height;
    private double width;

    @Override
    public String toString() {
        return "Housing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
