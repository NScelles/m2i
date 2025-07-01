package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private String name;
    private int sellin;
    private int quality;
    private String type;

    public void update(){
        int factor = (type.equalsIgnoreCase("Milk"))? 2 : 1;
        if(name.equalsIgnoreCase("Brie vieilli"))
            quality++;
        else{
            if (sellin == 0)
                quality -= 2 * factor;
            else
                quality -= factor;

            if (quality < 0)
                quality = 0;
            else if (quality > 50)
                quality = 50;
        }
        if (sellin > 0)
            sellin--;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return sellin == product.sellin && quality == product.quality && Objects.equals(name, product.name) && Objects.equals(type, product.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sellin, quality, type);
    }
}
