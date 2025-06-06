package org.example.tpproduct.models.articles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class Electronic extends Article {
    private int bateryDuration;

    public void update(String description, double price, int stock, LocalDate restockDate, int bateryDuration) {
        super.update(description, price, stock, restockDate);
        this.bateryDuration = bateryDuration;
    }

    @Override
    public String toString() {
        return "\nElectronic{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", restockDate=" + restockDate +
                ", bateryDuration=" + bateryDuration +
                '}';
    }
}
