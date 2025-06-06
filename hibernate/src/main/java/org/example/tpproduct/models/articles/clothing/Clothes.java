package org.example.tpproduct.models.articles.clothing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.tpproduct.models.articles.Article;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class Clothes extends Article {
    private int size;
    private Categories category;

    public void update(String description, double price, int stock, LocalDate restockDate, int size, Categories category) {
        super.update(description, price, stock, restockDate);
        this.size = size;
        this.category = category;
    }

    @Override
    public String toString() {
        return "\nClothes{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", restockDate=" + restockDate +
                ", size=" + size +
                ", category=" + category +
                '}';
    }
}
