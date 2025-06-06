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
public class Food extends Article {
    private LocalDate expiryDate;

    public void update(String description, double price, int stock, LocalDate restockDate,LocalDate expiryDate) {
        super.update(description, price, stock, restockDate);
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "\nFood{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", restockDate=" + restockDate +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
