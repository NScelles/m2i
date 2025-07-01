package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
