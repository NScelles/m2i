package org.example.tpcomputer.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String model;

    /** On met @Embedded pour signifier que l'attribut contient aussi les attributs de la classe dit "embarqué"
     * sur laquelle on viendra mettre @Embedded pour y faire le lien (Voir Classe Identification)
     *
     * Donc dans la BDD, on aura une seule table avec les attributs de la classe Computer et aussi de la classe Identification
     */
    @Embedded
    private Identification identification;
}
