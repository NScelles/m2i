package org.example.tpcomputer.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Processor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;
    private String name;
    private String model;


    /**
     * ATTENTION : Lorsque tu affiches un Processor la methode toString() affiche aussi le Computer associé
     * Et le Computer affiche lui aussi le Processer et cela à l'infini
     * pour régler le problème, il faut que tu génères la methode toString() mais sans le Computer comme si dessous
     */

    @OneToMany(mappedBy = "processor")
    private List<Computer> computers;

    public String getDisplay(){
        return "Brand: " + brand + "Nom: " + name + " | Model: " + model;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
