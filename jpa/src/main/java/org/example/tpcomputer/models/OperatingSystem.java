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
public class OperatingSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String version;

    /**
     * ATTENTION : Lorsque tu affiches un Processor la methode toString() affiche aussi le Computer associé
     * Et le Computer affiche lui aussi le Processer et cela à l'infini
     * pour régler le problème génère-toi même la methode toString() mais sans le Computer comme si dessous
     */

    @OneToMany
    @JoinColumn(name = "id")
    private List<Computer> computer;

    @Override
    public String toString() {
        return "OperatingSystem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
